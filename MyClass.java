/*

    author: Mark Jason T. Galang

*/

public class MyClass {
    public static void main(String args[]) {
        Color color = new Color(0.5, 0, 0.5); //change this
        
        System.out.println("Given: (" + color.R + ", " + color.G + ", " + color.B + ")\n");
        
        double V = Math.max(color.R, Math.max(color.G, color.B));
        System.out.printf("V = max{%.4f, %.4f, %.4f} = %.4f\n", color.R, color.G, color.B, V);
        
        double delta = V - Math.min(color.R, Math.min(color.G, color.B));
        System.out.printf("delta = %.4f - min{%.4f, %.4f, %.4f} = %.4f\n", V, color.R, color.G, color.B, delta);
        
        double S = delta / V;
        System.out.printf("S = %.4f / %.4f = %.4f\n\n", delta, V, S);
        
        double H = 0;
        if (color.R == V) {
            H = ((double) 1 / 6) * ((color.G - color.B) / delta);
            System.out.printf("H = 1 / 6 * ((%.4f - %.4f) / %.4f) = %.4f", color.G, color.B, delta, H);
        } else if (color.G == V) {
            H = ((double) 1 / 6) * (2 + (color.B - color.R) / delta);
            System.out.printf("H = 1 / 6 * (2 + (%.4f - %.4f) / %.4f) = %.4f", color.B, color.R, delta, H);
        } else if (color.B == V) {
            H = ((double) 1 / 6) * (4 + (color.R - color.G) / delta);
            System.out.printf("H = 1 / 6 * (4 + (%.4f - %.4f) / %.4f) = %.4f", color.R, color.G, delta, H);
        }
        
        if (H < 0) {
            H += 1;
        }
        
        System.out.printf("\n\nFinal Answer:\nH = %.4f \nS = %.4f \nV = %.4f\n", H, S, V);
    }
    
    static class Color {
        double R, G, B;
        
        Color(double R, double G, double B) {
            this.R = R;
            this.G = G;
            this.B = B;
        }
    }
}
