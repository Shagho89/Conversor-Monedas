import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solicitudes solicitud = new Solicitudes();
        ConvertirArchivo convertir = new ConvertirArchivo();
        String monedaBase = "";
        String monedaConvertida = "";
        double monto = 0.0;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Poner la 1era moneda a convertir");
            System.out.println("2. Poner la 2da moneda a convertir");
            System.out.println("3. Poner el valor a convertir");
            System.out.println("4. Salir del menú");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la moneda base (por ejemplo, USD): ");
                    monedaBase = scanner.next().toUpperCase();
                    break;
                case 2:
                    System.out.print("Ingrese la moneda a la que desea convertir (por ejemplo, EUR): ");
                    monedaConvertida = scanner.next().toUpperCase();
                    break;
                case 3:
                    System.out.print("Ingrese la cantidad a convertir: ");
                    monto = scanner.nextDouble();

                    if (monedaBase.isEmpty() || monedaConvertida.isEmpty()) {
                        System.out.println("Por favor, establezca primero las monedas.");
                    } else {
                        try {
                            Datos exchangeRate = solicitud.getExchangeRate(monedaBase, monedaConvertida);
                            double montoConvertido = monto * exchangeRate.rate();
                            System.out.printf("%.2f %s es igual a %.2f %s%n", monto, monedaBase, montoConvertido, monedaConvertida);
                            convertir.agregarmoneda(monedaBase, monedaConvertida, monto, montoConvertido);
                        } catch (Exception e) {
                            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del menú...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }
}