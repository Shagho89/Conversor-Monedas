import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class ConvertirArchivo {
        private static final String archivo = "Monedas.json";
        private final List<Conversiones> convertir = new ArrayList<>();
        private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        public void agregarmoneda(String monedaBase, String monedaConvertida, double monto, double montoConvertido) {
            convertir.add(new Conversiones(monedaBase, monedaConvertida, monto, montoConvertido));
            writeToFile();
        }

        private void writeToFile() {
            try (FileWriter writer = new FileWriter(archivo)) {
                gson.toJson(convertir, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static class Conversiones {
            private final String monedaBase;
            private final String monedaConvertida;
            private final double monto;
            private final double montoConvertido;

            public Conversiones(String monedaBase, String monedaConvertida, double monto, double montoConvertido) {
                this.monedaBase = monedaBase;
                this.monedaConvertida = monedaConvertida;
                this.monto = monto;
                this.montoConvertido = montoConvertido;
            }
        }
    }

