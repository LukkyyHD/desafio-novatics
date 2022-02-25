package atividade_02;

import java.util.HashSet;
import java.util.Set;

public class Atividade_02 {
    //armazena os valores do tabuleiro
    Set blockSet = new HashSet<>();
    int[][] board = {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                     {6, 7, 2, 1, 9, 5, 3, 4, 8},
                     {1, 9, 8, 3, 4, 2, 5, 6, 7},
                     {8, 5, 9, 7, 6, 1, 4, 2, 3},
                     {4, 2, 6, 8, 5, 3, 7, 9, 1},
                     {7, 1, 3, 9, 2, 4, 8, 5, 6},
                     {9, 6, 1, 5, 3, 7, 2, 8, 4},
                     {2, 8, 7, 4, 1, 9, 6, 3, 5},
                     {3, 4, 5, 2, 8, 6, 1, 7, 9,}};

    public static void main(String[] args) {
        Atividade_02 valida = new Atividade_02();
        valida.resultado();        
    }
    //validacao final
    public void resultado() {
        if (!validaSudoku(board)) {
            System.out.println("Invalido!");
        } else {
            System.out.println("Valido!");
        }
    }
    //metodo que compara cada casa do tabuleiro
    public boolean validaSudoku(int[][] board) {

        Set rowset = new HashSet<>();
        Set colset = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (colset.contains(board[i][j])) {
                    return false;
                }
                if (rowset.contains(board[j][i])) {
                    return false;
                }               
                if (board[i][j] != '.') {
                    colset.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    rowset.add(board[j][i]);
                }
            }            
            rowset.clear();
            colset.clear();
        }      
        int i = 0, j = 0;
        while (i < 9 && j < 9) {
            while (i < 9) {                
                if (!valido(board, i, j)) {
                    return false;
                }               
                i += 3;               
                blockSet.clear();
            }            
            i = 0;
            j += 3;
        }        
        return true;
    }    
    //checa se a sessao é valida
    private boolean valido(int[][] board, int i, int j) {        
        for (int x = i; x < i + 3; x++) {            
            for (int y = j; y < j + 3; y++) {                
                if (blockSet.contains(board[x][y])) {
                    return false;
                }                
                if (board[x][y] != '.') {
                    blockSet.add(board[x][y]);
                }
            }
        }      
        return true;
    }
}
