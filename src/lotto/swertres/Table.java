/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.swertres;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Table {
    //<editor-fold defaultstate="collapsed" desc=" swertres "> 

    public static ArrayListModel tbl_swertres_ALM;
    public static TblswertresModel tbl_swertres_M;

    public static void init_tbl_swertres(JTable tbl_swertres) {
        tbl_swertres_ALM = new ArrayListModel();
        tbl_swertres_M = new TblswertresModel(tbl_swertres_ALM);
        tbl_swertres.setModel(tbl_swertres_M);
        tbl_swertres.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tbl_swertres.setRowHeight(25);
        int[] tbl_widths_swertres = {100, 100, 0, 0, 0};
        for (int i = 0, n = tbl_widths_swertres.length; i < n; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_swertres, i, tbl_widths_swertres[i]);
        }
        Dimension d = tbl_swertres.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_swertres.getTableHeader().setPreferredSize(d);
        tbl_swertres.getTableHeader().setFont(new java.awt.Font("Arial", 0, 14));
        tbl_swertres.setRowHeight(25);
        tbl_swertres.setFont(new java.awt.Font("Arial", 0, 14));
//        TableColumnModel tcm = tbl_swertres.getColumnModel();
//        TableColumn tm = tcm.getColumn(1);
//        tm.setCellRenderer(new MultiLabelRenderer());
    }

    public static void loadData_swertres(List<Swertres.to_swertres> acc) {
        tbl_swertres_ALM.clear();
        tbl_swertres_ALM.addAll(acc);
    }

    public static class TblswertresModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Date", "Result", "", "", ""
        };

        public TblswertresModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            Swertres.to_swertres tt = (Swertres.to_swertres) getRow(row);
            switch (col) {
                case 0:
                    return " " + DateType.convert_slash_datetime2(tt.draw_date);
                case 1:
                    return " " + tt.result;
                case 2:
                    return tt.result;
                case 3:
                    return tt.draw_date;
                default:
                    return tt.winners;
            }
        }
    }
}
