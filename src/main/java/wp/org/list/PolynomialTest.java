package wp.org.list;

public class PolynomialTest {
    public static void main(String[] args){
        Polynomial polynomial1 = new Polynomial();
        polynomial1.createPolyn();
        System.out.println(polynomial1.toString());
        System.out.println(polynomial1.polynomialLentgh());

        Polynomial polynomial2 = new Polynomial();
        polynomial2.createPolyn();
        System.out.println(polynomial2.toString());
        System.out.println(polynomial2.polynomialLentgh());

        //addTest
//        System.out.println(polynomial1.addPolynomial(polynomial2.getPolynomial()));
//        System.out.println(polynomial1.toString());

        //substractTest
//        System.out.println(polynomial1.substractPolynomial(polynomial2.getPolynomial()));
//        System.out.println(polynomial1.toString());

        //multi
        System.out.println(polynomial1.multiPolynomial(polynomial2.getPolynomial()));
        System.out.println(polynomial1.toString());
    }
}
