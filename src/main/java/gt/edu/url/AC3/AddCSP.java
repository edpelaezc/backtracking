package gt.edu.url.AC3;

import java.util.List;

public class AddCSP extends CSPAC3 {
    public static final Variable A = new Variable("A");
    public static final Variable B = new Variable("B");
    public static final Variable C = new Variable("C");
    public static final Variable D = new Variable("D");
    public static final Variable E = new Variable("E");
    public static final Variable F = new Variable("F");
    public static final Variable G = new Variable("G");
    public static final Variable H = new Variable("H");
    public static final Variable I = new Variable("I");
    public static final Variable J = new Variable("J");
    public static final Variable K = new Variable("K");
    public static final Variable L = new Variable("L");
    public static final Variable M = new Variable("M");
    public static final Variable N = new Variable("N");
    public static final Variable O = new Variable("O");
    public static final Variable P = new Variable("P");
    public static final Variable Q = new Variable("Q");
    public static final Variable R = new Variable("R");
    public static final Variable S = new Variable("S");
    public static final Variable T = new Variable("T");
    public static final Variable U = new Variable("U");
    public static final Variable V = new Variable("V");
    public static final Variable W = new Variable("W");
    public static final Variable X = new Variable("X");
    public static final Variable Y = new Variable("Y");
    public static final Variable Z = new Variable("Z");
    public static final Variable AA = new Variable("AA");
    public static final String RED = "rojo";
    public static final String GREEN = "verde";
    public static final String BLUE = "azul";
    public static final String BLACK = "Black";

    private static List<Variable> collectVariables() {
        return List.of(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, AA);
    }

    public AddCSP() {
        super(collectVariables());

        Domain colors = new Domain(new Object[] { RED, GREEN, BLUE });

        for (Variable var : getVariables())
            setDomain(var, colors);

        addConstraint(new NotEqualConstraint(A, B));
        addConstraint(new NotEqualConstraint(A, V));
        addConstraint(new NotEqualConstraint(B, V));
        addConstraint(new NotEqualConstraint(C, F));
        addConstraint(new NotEqualConstraint(C, D));
        addConstraint(new NotEqualConstraint(C, H));
        addConstraint(new NotEqualConstraint(D, G));
        addConstraint(new NotEqualConstraint(D, H));
        addConstraint(new NotEqualConstraint(E, I));
        addConstraint(new NotEqualConstraint(F, K));
        addConstraint(new NotEqualConstraint(G, K));
        addConstraint(new NotEqualConstraint(H, V));
        addConstraint(new NotEqualConstraint(H, M));
        addConstraint(new NotEqualConstraint(I, M));
        addConstraint(new NotEqualConstraint(J, K));
        addConstraint(new NotEqualConstraint(J, N));
        addConstraint(new NotEqualConstraint(K, O));
        addConstraint(new NotEqualConstraint(L, P));
        addConstraint(new NotEqualConstraint(L, Q));
        addConstraint(new NotEqualConstraint(M, Q));
        addConstraint(new NotEqualConstraint(P, S));
        addConstraint(new NotEqualConstraint(P, T));
        addConstraint(new NotEqualConstraint(P, U));
        addConstraint(new NotEqualConstraint(R, W));
        addConstraint(new NotEqualConstraint(R, X));
        addConstraint(new NotEqualConstraint(R, S));
        addConstraint(new NotEqualConstraint(S, X));
        addConstraint(new NotEqualConstraint(S, Y));
        addConstraint(new NotEqualConstraint(S, Z));
        addConstraint(new NotEqualConstraint(T, Z));
        addConstraint(new NotEqualConstraint(T, AA));
        addConstraint(new NotEqualConstraint(T, U));
        addConstraint(new NotEqualConstraint(U, AA));
        addConstraint(new NotEqualConstraint(V, W));
        addConstraint(new NotEqualConstraint(W, X));
        addConstraint(new NotEqualConstraint(X, Y));
        addConstraint(new NotEqualConstraint(Y, Z));
        addConstraint(new NotEqualConstraint(Z, AA));
    }

    public void solve(){
        Backtracking solver = new Backtracking();
        Assignment solution = solver.solve(this.copy());
        System.out.println(solution);
    }
}
