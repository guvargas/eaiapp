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

import Controller.MainController;
import Data.BancoConversas;

public class JTableLista extends AbstractTableModel {
    private List<Conversa> conversa ;
    private String[] columNome = { "Nome", "Ultima Mensagem", "Porta" };
    private MainController mc;

    public JTableLista(MainController mc) {
      this.mc = mc;

         conversa = mc.getMinhasConversas();
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
        switch (columnIndex) {
            case 0:
                return conversa.get(rowIndex).getNome();
            case 1:
                return conversa.get(rowIndex).getUltimaMensagem().getConteudo();
            case 2:
                return conversa.get(rowIndex).getPorta();
        }
        return null;
    }

    public void refresh() {
        conversa = mc.getMinhasConversas();
        this.fireTableDataChanged();
    }

    public void addConversa(Conversa c) {
        this.conversa.add(c);
        this.fireTableDataChanged();
    }

    // talvez aqui tenha que ter um atualizar a tabela
    // ai ele da um refresh na tabela

    public void removerConversa(int rowIndex) {
        this.conversa.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public void abrirConversa(int rowIndex, MainController controller) {
        Conversa c = this.conversa.get(rowIndex);
        ConversaCliente cc = new ConversaCliente(c,controller);
        cc.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cc.setVisible(true);
    }

}
