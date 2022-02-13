/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Conversa;
import View.ConversaCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

public class JTableLista extends AbstractTableModel {
    private List<Conversa> conversa = new ArrayList<>();
    private String[] columNome = {"Nome", "Ultima Mensagem", "Porta"};
    
    public JTableLista(){
    }
    
    @Override
    public String getColumnName(int column) {
        return columNome[column];
    }
    
    @Override
    public int getRowCount() {
        return conversa.size();
    }

    @Override
    public int getColumnCount() {
        return columNome.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return conversa.get(rowIndex).getNome();
            case 1:
                return conversa.get(rowIndex).getUltimaMensagem().getConteudo();
            case 2:
                return conversa.get(rowIndex).getPorta();
        }
        return null;
    }
    
    public void addConversa(Conversa c){
        this.conversa.add(c);
        this.fireTableDataChanged();
    }
    
    public void removerConversa(int rowIndex){
        this.conversa.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void abrirConversa(int rowIndex){
        Conversa c = this.conversa.get(rowIndex);
        ConversaCliente cc = new ConversaCliente(c);
        cc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cc.setVisible(true);
    }
    
}
