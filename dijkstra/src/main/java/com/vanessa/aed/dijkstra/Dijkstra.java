package com.vanessa.aed.dijkstra;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
/**
 *
 * @author vanessa aldrighi
 */
public class Dijkstra {
    static final int num_Vertices = 20;  //Número máx de vértices
    
    // Descobrir o menor caminho
     private int minDistance(int caminho_array[], Boolean camSet[]){ 
        // Valor minimo é o máx inteiro inicialmente 
        int min = Integer.MAX_VALUE, min_index = -1; 
        for (int v = 0; v < num_Vertices; v++)
            if (camSet[v] == false && caminho_array[v] <= min){ 
                min = caminho_array[v]; 
                min_index = v;}
        return min_index; 
    } 
    
// Implementação do dijkstra
    void dijkstra_minimo(int graph[][], int ini_node, int final_node)  { 
        int caminho_array[] = new int[num_Vertices]; // Array com os menores caminhos de cada vértice
        Boolean camSet[] = new Boolean[num_Vertices]; // Contém todos os vértices que já possuem caminho mínimo "fechado"
   
        // Transforma todos valores dos arrays em infinito e falso inicialmente 
        for (int i = 0; i < num_Vertices; i++) { 
            caminho_array[i] = Integer.MAX_VALUE; 
            camSet[i] = false; } 
        caminho_array[ini_node] = 0; // Caminho do vértice de origem até ele mesmo é zero. 
        
        // Achar a menor distância para todos vértices do inicio ate o de destino
        for (int count = ini_node; count < final_node; count++) { 
            // Chama o método pra achar o vertice com menor caminho
            int vIndex = minDistance(caminho_array, camSet); 
              // O vertice vindex foi processado e atualizado
            camSet[vIndex] = true; 
              // Processar os nós adjacentes do vértice atual
            for (int v = ini_node; v <= final_node; v++) {
                //Verificar se existem valores menores que zero
                if(graph[vIndex][v]<0){
                    System.out.println("ERRO: Vértice com peso inválido.");
                    System.exit(0);}
                 //Update do caminho
                if ((!camSet[v]) && (graph[vIndex][v] != 0) && (caminho_array[vIndex] != Integer.MAX_VALUE) && ((caminho_array[vIndex] 
                            + graph[vIndex][v]) < caminho_array[v]))
                            caminho_array[v] = caminho_array[vIndex] + graph[vIndex][v];}  
    }
            System.out.println("Menor caminho do vértice v(" + ini_node + ") até o vértice v(" + final_node + ") é: " + caminho_array[final_node]);} 
}