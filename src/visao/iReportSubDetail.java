/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.GeraRelatorio;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Paulo Henrique Cayres
 */
public class iReportSubDetail {
    
        public static void main(String[] args) throws Exception {
        GeraRelatorio geraRelat = new GeraRelatorio();
        
        JasperPrint relatorio;
        try {
            HashMap map = new HashMap();
            map.put("SUBREPORT_DIR", "src/reports/"); // define a localização do sub-relatório
            relatorio = geraRelat.gerarRelatorio("src/reports/DependentesPorFuncionario.jasper", map);
            JasperViewer.viewReport(relatorio, false);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }	
        
    }    

}
