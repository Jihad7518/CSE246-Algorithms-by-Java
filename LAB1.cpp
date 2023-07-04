#include<iostream>
using namespace std;

    int vArr[20][20];
    int count = 0;

    void displayMat(int v){
       for(int i = 0; i < v; i++){
         for(int j = 0; j < v; j++) {
             cout << vArr[i][j] << " ";
          }
         cout << endl;
       }
    }
    void add_edge(int u, int v){
       vArr[u][v] = 1;
       vArr[v][u] = 1;
    }
    main(int a, char* b[]){
        int v;
        cout << "Enter Number of Vertices";
        cin >> v;

        add_edge(0, 4);
        add_edge(0, 3);
        add_edge(1, 2);
        add_edge(1, 4);
        add_edge(1, 5);
        add_edge(2, 3);
        add_edge(2, 5);
        add_edge(5, 3);
        add_edge(5, 4);
        displayMat(v);
    }
