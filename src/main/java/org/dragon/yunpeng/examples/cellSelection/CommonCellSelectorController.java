package org.dragon.yunpeng.examples.cellSelection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author yunpeng.li
 */
public class CommonCellSelectorController implements Initializable {

  private int totalCells;
  private ToggleButton[] cells;

  @FXML
  private ToggleButton allBtn;

  @FXML
  private ToggleButton noneBtn;

  private static final int GRID_24 = 24;
  private static final int GRID_16 = 16;

  @FXML
  private GridPane cellGridPane;

  /**
   *
   * @param code 0 = 24, 1 = 16
   */
  public CommonCellSelectorController(int code) {

    if (code == 0) {

      totalCells = GRID_24;
    } else {

      totalCells = GRID_16;
    }

  }

  private void initComponents() {

    List<RowColumnIndex> rowColumnIndexList = null;

    if (totalCells == GRID_16) {
      rowColumnIndexList = this.initRowColumnIndexList(4, 4);
    } else if (totalCells == GRID_24) {
      rowColumnIndexList = this.initRowColumnIndexList(4, 6);
    }

    cells = new ToggleButton[totalCells];
    for (int i = 0; i < totalCells; i++) {
      ToggleButton cellButton = new ToggleButton();
      cells[i] = cellButton;

      cellButton.setText(Integer.toString(i + 1));

      cellButton.setFont(Font.font("arial", 14));
      cellButton.setMinSize(50, 50);
      cellButton.setStyle("-fx-base: red;");
      cellButton.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {

          if (cellButton.isSelected()) {
            cellButton.setStyle("-fx-base: green;");
          } else {
            cellButton.setStyle("-fx-base: red;");
          }

          printSelectedCells();
        }
      });

      int colIndex = rowColumnIndexList.get(i).getColumnIndex();
      int rowIndex = rowColumnIndexList.get(i).getRowIndex();

      cellGridPane.add(cellButton, colIndex, rowIndex);
    }

    allBtn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {

        for (ToggleButton cellButton : cells) {
          cellButton.setSelected(true);
          cellButton.setStyle("-fx-base: green;");
        }

        printSelectedCells();
      }
    });

    noneBtn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {

        for (ToggleButton cellButton : cells) {
          cellButton.setSelected(false);
          cellButton.setStyle("-fx-base: red;");
        }
        printSelectedCells();

      }
    });

    ToggleGroup group = new ToggleGroup();
    allBtn.setToggleGroup(group);
    noneBtn.setToggleGroup(group);
  }

  private void printSelectedCells() {

    System.out.print("Selected cells: [");
    for (int i = 0; i < cells.length; i++) {

      if (cells[i].isSelected()) {

        System.out.print((i + 1) + " ");
      }
    }
    System.out.print("]");
    System.out.println();
    printSelectedCellArray();
  }

  private void printSelectedCellArray() {

    boolean[] selectedCells = getSelectedCells();
    System.out.print("Selected cell array: [");
    for (int i = 0; i < selectedCells.length; i++) {
      System.out.print(selectedCells[i] + " ");
    }

    System.out.print("]");
    System.out.println();
  }

  /**
   * Returns a boolean[24] array that shows which cells are selected. Returns <null> if no cells
   * have been selected.
   *
   * @return boolean[24] array that shows which cells are selected, or <null> if none.
   */
  public boolean[] getSelectedCells() {
    boolean[] selectedCells = new boolean[cells.length];
    for (int i = 0; i < cells.length; i++) {
      if (cells[i].isSelected()) {
        selectedCells[i] = true;
      } else {
        selectedCells[i] = false;
      }
    }
    return selectedCells;
  }

  /**
   * This sets the selected cells
   *
   * @param selectedCells
   */
  public void setSelectCells(boolean[] selectedCells) {
    for (int i = 0; i < selectedCells.length; i++) {
      cells[i].setSelected(selectedCells[i]);

      if (selectedCells[i]) {
        cells[i].setStyle("-fx-base: green;");
      } else {
        cells[i].setStyle("-fx-base: red;");
      }
    }
  }

  private List<RowColumnIndex> initRowColumnIndexList(int numRows, int numCols) {

    List<RowColumnIndex> rowColumnIndexList = new ArrayList<RowColumnIndex>();

    for (int r = 0; r < numRows; r++) {

      for (int c = 0; c < numCols; c++) {

        RowColumnIndex rowColumnIndex = new RowColumnIndex();
        rowColumnIndex.setRowIndex(r);
        rowColumnIndex.setColumnIndex(c);

        rowColumnIndexList.add(rowColumnIndex);
      }
    }

    return rowColumnIndexList;
  }

  public class RowColumnIndex {

    private int rowIndex;
    private int columnIndex;

    public int getRowIndex() {
      return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
      this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
      return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
      this.columnIndex = columnIndex;
    }
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.initComponents();
  }

}

