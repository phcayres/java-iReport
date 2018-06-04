/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Paulo Henrique Cayres
 */
public class GeraRelatorio {

    private Connection con;
    public GeraRelatorio() throws Exception {
      this.con = new ConnectionFactoryComProperties().getConnection();
    }
    
    public JasperPrint gerarRelatorio(String arquivoJasper, HashMap map) throws JRException {
        JasperPrint rel = null;
        try {
            rel = JasperFillManager.fillReport(arquivoJasper, map, this.con);
        } catch (JRException e) {
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(),"Mensagem",javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        return rel;
    }    
}

