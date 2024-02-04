
package ec.edu.epn.modelo;
import ec.edu.epn.excepciones.ExcepcionTrianguloNoValido;

class Triangulo {
    private double lado1, lado2, lado3;

    public Triangulo(double lado1, double lado2, double lado3) throws ExcepcionTrianguloNoValido {
        if (esTrianguloValido(lado1, lado2, lado3)) {
            this.lado1 = lado1;
            this.lado2 = lado2;
            this.lado3 = lado3;
        } else {
            throw new ExcepcionTrianguloNoValido("Los lados proporcionados no forman un triángulo válido");
        }
    }

    public String identificarTipoTriangulo() {
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2.0;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    private boolean esTrianguloValido(double lado1, double lado2, double lado3) {
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }
}