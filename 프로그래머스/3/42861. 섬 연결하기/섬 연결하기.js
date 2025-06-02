function find(parent, x){
    if(parent[x] == x){
        return x;
    }
    
    parent[x] = find(parent, parent[x]);
    return parent[x];
}

function union(parent, rank, x, y){
    const xroot = find(parent, x);
    const yroot = find(parent, y);
    
    if(rank[xroot] < rank[yroot]){
        parent[xroot] = yroot;
    } else if(rank[xroot] > rank[yroot]){
        parent[yroot] = xroot;
    } else {
        parent[yroot] = xroot;
        rank[xroot] += 1;
    }
}


function solution(n, costs) {
    costs.sort((a,b) => a[2]-b[2]);
    
    const parents = Array.from({length: n}, (_,i) =>i);
    
    const rank = new Array(n).fill(0);
    
    let minCost = 0;
    let edges = 0;
    
    for(const edge of costs){
        if(edges === n-1){
            break;
        }
        
        const xroot = find(parents,edge[0]);
        const yroot = find(parents,edge[1]);
        
        
        if(xroot != yroot) {
            union(parents, rank, xroot, yroot);
            
            minCost += edge[2];
            edges += 1
        }
    }
    
    return minCost;
}