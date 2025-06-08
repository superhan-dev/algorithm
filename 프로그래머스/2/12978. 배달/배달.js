class MinHeap {
    constructor(){
        this.heap = [];
    }
    
    size(){
        return this.heap.length;
    }
    
    swap(a,b){
        [this.heap[a], this.heap[b]] = [this.heap[b], this.heap[a]];
    }
    
    push(item){
        this.heap.push(item);
        this.bubbleUp();
    }
    
    pop(){
        if(this.size() === 0) return null;
        
        let min = this.heap[0];
        this.heap[0] = this.heap[this.size()-1];
        this.heap.pop();
        this.bubbleDown()
        
        return min;
    }
    
    bubbleUp(){
        let index = this.size()-1;
        
        while(index > 0){
            let parent = Math.floor((index - 1) / 2);
            if(this.heap[parent] <= this.heap[index]) break;
            
            this.swap(index, parent);
            index = parent;
        }
    }
    
    bubbleDown(){
        let index = 0;
        
        while(index * 2 + 1 < this.size()) {
            let left = index * 2 + 1;
            let right = index * 2 + 2;
            
            let smaller = right < this.size() && this.heap[right] < this.heap[left] ? right : left;
            
            if(this.heap[index] <= this.heap[smaller]) break;
            
            this.swap(index, smaller);
            index = smaller;
        }
    }
}

function solution(N,road,K){
	const graph = Array.from({length : N+1}, () => []);

	const distances = Array(N+1).fill(Infinity);

	distances[1] = 0;

	for(const [a,b,cost] of road){
		graph[a].push([b, cost]);
		graph[b].push([a, cost]);
	}
	const heap = new MinHeap();
    
    heap.push([0,1]);
    while(heap.size() > 0){
        const [dist, node] = heap.pop();
        for(const [nextNode,nextDist] of graph[node]){
            const c = dist + nextDist;
            
            if(c < distances[nextNode]){
                distances[nextNode] = c;
                heap.push([c,nextNode])
            }
        }
    }


	return distances.filter(dist => dist <= K).length
}