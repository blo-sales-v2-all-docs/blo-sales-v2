package com.blo.sales.v2.plugins.xlxs;

import com.blo.sales.v2.utils.BloSalesV2Utils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public final class BloSalesV2CSVPlugin {
    
    private static final String CSV_SEPARATOR = ";";
    
    private static final String CSV_SEPARATOR_CONFIG = "sep=;";
    
    private static final String ISO_8859_1 = "ISO-8859-1";
    
    private static final String CSV_FORMAT_TEXT = "=\"%s\"";
    
    private BloSalesV2CSVPlugin() { }
    
    /**
     * 
     * @param headers
     * @param rows
     * @param csvName
     * @param firstColDiff bandera que indica si la primer fila antes de titulos es diferente
     */
    public static void exportFile(String[] headers, BloSalesV2CSVCols rows, String csvName, boolean firstColDiff) {
        if (rows.getCols() != null && !rows.getCols().isEmpty()) {
            final var chooser = new JFileChooser();
            chooser.setDialogTitle(String.format("Guardar %s", csvName));
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    final var archivo = new File(chooser.getSelectedFile().toString() + ".csv");            
                    // 1. Abrimos el flujo de salida básico
                    final var fos = new FileOutputStream(archivo);
                    // 2. Especificamos la codificación como String explícitamente
                    // Esto evita que Java lo confunda con un 'int'
                    final var osw = new OutputStreamWriter(fos, ISO_8859_1);
                    // 3. Envolvemos en el búfer para escribir línea por línea
                    BufferedWriter bw = new BufferedWriter(osw);
                    // Instrucción para que Excel divida las celdas automáticamente
                    bw.write(CSV_SEPARATOR_CONFIG);
                    bw.newLine();
                    // primera fila diferente antes de titulos
                    if (firstColDiff) {
                        final var firstRow = rows.getCols().get(0);
                        bw.write(createRow(firstRow));
                        bw.newLine();
                        rows.getCols().remove(0);
                    }
                    // Encabezados
                    bw.write(headersFromArray(headers));
                    bw.newLine();
                    if (rows.getCols()!= null && !rows.getCols().isEmpty()) {
                        StringBuilder strBuild = null;
                        for (final var e: rows.getCols()) {
                            strBuild = new StringBuilder();
                            strBuild.append(createRow(e));
                            strBuild.append(CSV_SEPARATOR);
                            strBuild.append(BloSalesV2Utils.EMPTY_STRING);
                            bw.write(strBuild.toString());
                            bw.newLine();
                        }
                    }
                    bw.close(); // Importante cerrar para que se guarde el archivo
                    JOptionPane.showMessageDialog(null, "¡Completo!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
        }
    }
    
    private static String headersFromArray(String[] headers) {
        return String.join(CSV_SEPARATOR, headers);
    }
    
    private static String createRow(Object[] row) {
    return Arrays.stream(row)
            .map(obj -> {
                final var value = (obj == null) ? "" : String.valueOf(obj).trim();
                // Si el valor es puramente numérico y largo (Código de barras)
                // Usamos el formato ="valor" para que Excel lo trate como Texto
                if (value.matches("\\d{10,}")) {
                    return String.format(CSV_FORMAT_TEXT, value);
                }
                return value;
            })
            .collect(Collectors.joining(CSV_SEPARATOR));
    }
}
