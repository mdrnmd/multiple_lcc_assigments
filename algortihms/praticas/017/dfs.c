#include <stdio.h>
#include <stdbool.h>
#define MAX 200     // Maximo numero de nos
int n;              // Numero de nos do grafo
bool adj[MAX][MAX]; // Matriz de adjacencias
bool visited[MAX];  // Que nos ja foram visitados?
void dfs(int v) {
  int i;
  //printf("%d ", v);
  visited[v] = 1;
  for (i=1; i<=n; i++)
    if (adj[v][i] && !visited[i])
      dfs(i);
}
int main() {
  int i, edges, a, b;
  scanf("%d", &n);
  scanf("%d", &edges);
  if ( edges == 0)
    printf("%d\n", n);
    else {
        for (i=0; i<edges; i++) {
          scanf("%d %d", &a, &b);
          adj[a][b] = adj[b][a] = 1;
      
        }



        
        int count=0;
        for ( i=1; i<= n; i++)
            visited[i]=0;
        for ( i = 1; i <= n; ++i)
        {
          if ( !visited[i] ){
            count++;
            dfs(i);
          }
        }
        printf("%d\n",count );
    
    }
 
  
  return 0;
}