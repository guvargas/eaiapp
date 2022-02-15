/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.Conversa;
import View.ConversaCliente;
import java.util.List;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;

import Controller.MainController;

public class JTableLista extends AbstractTableModel {
    private List<Conversa> listaConversasExibidas ;
    private String[] columNome = { "Nome", "Ultima Mensagem", "Porta" };
    private MainController mc;

    public JTableLista(MainController mc) {
      this.mc = mc;

         listaConversasExibidas = mc.getMinhasConversas();
    }

    @Override
    public String getColumnName(int column) {
        return columNome[column];
    }

    @Override
    public int getRowCount() {
        return listaConversasExibidas.size();
    }

    @Override
    public int getColumnCount() {
        return columNome.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listaConversasExibidas.get(rowIndex).getNome();
            case 1:
                return listaConversasExibidas.get(rowIndex).getUltimaMensagem().getConteudo();
            case 2:
                return listaConversasExibidas.get(rowIndex).getPorta();
        }
        return null;
    }

    public void refresh() {
        listaConversasExibidas = mc.getMinhasConversas();
        this.fireTableDataChanged();
    }

    public void addConversa(Conversa c) {
        this.listaConversasExibidas.add(c);
        this.fireTableDataChanged();
    }

    // talvez aqui tenha que ter um atualizar a tabela
    // ai ele da um refresh na tabela

    public void removerConversa(int rowIndex) {
        this.listaConversasExibidas.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void abrirConversa(int rowIndex, MainController controller) {
        Conversa c = this.listaConversasExibidas.get(rowIndex);
        ConversaCliente cc = new ConversaCliente(c,controller);
        cc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cc.setVisible(true);
    }

}
