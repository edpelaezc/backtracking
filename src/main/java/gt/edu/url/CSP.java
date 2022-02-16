package gt.edu.url;

import java.util.*;

public class CSP <V, D> {
    private List<V> variables;
    private Map<V, List<D>> domains;
    private Map<V, List<Constraint<V, D>>> constraints = new HashMap<>();

    public CSP(List<V> variables, Map<V, List<D>> domains){
        this.variables = variables;
        this.domains = domains;

        for (V variable:variables) {
            constraints.put(variable, new ArrayList<Constraint<V, D>>());

            // cada variable debe tener un dominio asignado
            if (!domains.containsKey(variable)){
                throw new IllegalArgumentException("La variable " + variable + " no contiene un dominio.");
            }
        }
    }

    public void addConstraint(Constraint<V, D> constraint){
        for (V variable:constraint.variables){
            // la variable que se encuentra en el constraint tambièn sea parte del CSP

            if (!this.variables.contains(variable)){
                throw new IllegalArgumentException("La variable " + variable + " no se encuentra en el CSP.");
            }

            constraints.get(variable).add(constraint);
        }
    }

    public boolean consistent(V variable, Map<V, D> assignment){
        for (Constraint<V, D> constraint:this.constraints.get(variable)){
            if (!constraint.satisfied(assignment)){
                return false;
            }
        }

        return true;
    }

    public Map<V, D> backtrack(){
        return backtrack(new HashMap<V, D>());
    }

    public Map<V, D> backtrack(final Map<V, D> assignment){
        // si la asignación es completa (si cada variable tiene un valor)
        if (variables.size() == assignment.size()){
            return assignment;
        }

        // seleccionar variable no asignada
        V unasigned = variables.stream()
                                .filter(v -> !assignment.containsKey(v))
                                .findFirst().get();

        for (D value:domains.get(unasigned)){
            System.out.println("Variable: " + unasigned + ". Valor: " + value);

            // probar una asignación
            // 1. Crear copia de asignación anterior
            Map<V, D> localAssignment = new HashMap<>(assignment);

            // 2. Probar (aka asignar un valor)
            localAssignment.put(unasigned, value);

            // 3. Verificar la consistencia de la asignación
            if (consistent(unasigned, localAssignment)){
                Map<V, D> result = backtrack(localAssignment);

                if (result != null){
                    return result;
                }
            }
        }

        return null;
    }

}
