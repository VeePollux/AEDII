/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.vanessa.aed.kruskal;
import java.util.*; 
import java.lang.*; 
import java.io.*; 

/**
 *
 * @Vanessa Aldrighi
 */
public class Kruskal {
    static int[] vertices;
 
// Arvore minima com algoritmo de Kruskal
static int algo_kruskal(int graph[][], int num_Vertices){
    if(num_Vertices>20){
        System.out.println("ERRO: Quantidade de vértices inválida.");
        System.exit(0);
    }
        
    vertices = new int[num_Vertices]; //Iniciando o array com o conjunto de vértices

    int minconst = 0; // Constante minima da arvore
    
    // Iniciando cada conjunto disjunto
    for (int i = 0; i < num_Vertices; i++)
        vertices[i] = i;
    
    //Colocando todos os vertices sem conexão representados como 0 para valor máximo
    //Assim não afeta o caminho minimo
    //Verificação de peso menor que 0 em arestas
    for (int i = 0; i < num_Vertices; i++)
        for (int j = 0; j < num_Vertices; j++){
            if(graph[i][j] == 0)
                graph[i][j] = Integer.MAX_VALUE;
            if(graph[i][j]<0){  
                System.out.println("ERRO: Vértice com peso inválido.");
                System.exit(0);}
        }
            
    
    // Verifica o menor caminho em ordem
    int aresta_count = 0;
    while (aresta_count < num_Vertices - 1){
        int min = Integer.MAX_VALUE, orig = -1, dest = -1;
        for (int i = 0; i < num_Vertices; i++)
            for (int j = 0; j < num_Vertices; j++)
                //Evita a seleção do mesmo elemento ou elementos já selecionados
                //E verifica se é o menor valor
                if (find(i) != find(j) && graph[i][j] < min){
                    min = graph[i][j];
                    orig = i;
                    dest = j;
                }
        //Coloca no array
        union(orig, dest);
        System.out.printf("Conjunto %d: (%d, %d)\nValor do caminho: %d \n",aresta_count++, orig, dest, min);
        minconst += min;
    }
    
    return minconst;
}

// Encontra no conjunto qual vértice ainda não foi setado
//Só retorna o valor de i depois que encontrar no array pai qual pai[i] == i
static int find(int i){
    while (vertices[i] != i)
        i = vertices[i];
    return i;
}
 
//Organiza no array a ordem dos elementos que foram selecionados no conjunto
//Para não haver elementos repetidos
static void union(int i, int j){
    int a = find(i);
    int b = find(j);
    vertices[a] = b;
}
}
