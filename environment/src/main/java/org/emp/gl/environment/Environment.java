package org.emp.gl.environment;

public class Environment {



    int matrice[][] = new int[10][10];

    public Environment(){
        for (int i=0; i<(matrice.length); i++ ) {
            for (int j=0;j<matrice[i].length;j++)
                matrice[i][j] = 0;
        }
    }

    //obstacle = int m[][] = {{1,2},{4,5}};

    public int[][] createMatrice(int obstacles [][]){

        for (int i=0; i<(obstacles.length); i++ ) {
            this.matrice[obstacles[i][0]][obstacles[i][1]] = 1;
        }
        return this.matrice;
    }

}
