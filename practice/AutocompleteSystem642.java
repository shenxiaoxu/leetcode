class AutocompleteSystem {
    TrieNode head;
    TrieNode inputCurrent;
    String inputSoFar;
    class TrieNode{
        int wordEnding = -1;
        Map<Character, TrieNode> next;
        public TrieNode(){
            this.next = new HashMap();
        }
    }
    public AutocompleteSystem(String[] sentences, int[] times) {
        //build trie
        this.head = new TrieNode();
        this.inputCurrent = head;
        this.inputSoFar = "";
        int idx = 0;
        for(String str : sentences){
            int length = str.length();
            int frequency = times[idx++];
            TrieNode current = this.head;
            for(int i = 0; i <= length - 1; i++){
                Character c = str.charAt(i);
                if(!current.next.containsKey(c)){
                    //System.out.println(c);
                    current.next.put(c, new TrieNode());
                }
                current = current.next.get(c);
            }
            current.wordEnding = frequency;
            //System.out.println(frequency);
        }
    }
    
    public List<String> input(char c) {
        //System.out.println(this.inputSoFar);
        if(c == '#'){
            inputCurrent = head;
            for(int i = 0; i < inputSoFar.length(); i++){
                Character tmp = inputSoFar.charAt(i);
                if(!inputCurrent.next.containsKey(tmp)){
                    inputCurrent.next.put(tmp, new TrieNode());
                }
                inputCurrent = inputCurrent.next.get(tmp);                
            }//store input so far
            if(inputCurrent.wordEnding == -1){
                inputCurrent.wordEnding = 1;
            }else{
                inputCurrent.wordEnding = inputCurrent.wordEnding + 1;
            }
            //System.out.println(inputCurrent.wordEnding + " " + inputSoFar);
            inputCurrent = head;//restore inputCurrent;
            inputSoFar = "";//restore inputSoFar;
            return new ArrayList<String>();
        }
    
        inputSoFar += c;//store input
        //search trie to return result
        PriorityQueue<Pair<String, Integer>> result = new PriorityQueue<Pair<String, Integer>>(new Comparator<Pair<String, Integer>>(){
            //override
            public int compare(Pair<String, Integer> p1, Pair<String, Integer> p2){
                if(p1.getValue() < p2.getValue()){
                    return 1;
                }else if(p1.getValue() > p2.getValue()){
                    return -1;
                }else{
                    return -p2.getKey().compareTo(p1.getKey());
                }
            } 
        });
        List<String> resultlist = new ArrayList();
        if(inputCurrent.next.containsKey(c)){
            inputCurrent = inputCurrent.next.get(c);
            getRemainingString(inputCurrent, inputSoFar, result);
            while(result.size() != 0){
                Pair<String, Integer> entry = result.poll();
                //System.out.println(entry.getKey() + " " + entry.getValue());
                if(resultlist.size() < 3){
                    resultlist.add(entry.getKey());
                }else{
                    return resultlist;
                }
            }
        }
        return resultlist;
    }
    private void getRemainingString(TrieNode remaining, String sub, PriorityQueue<Pair<String, Integer>> result){//recursive to get trie remaining string.
        //System.out.println(sub);
        if(remaining.wordEnding != -1){
            result.add(new Pair(new String(sub), remaining.wordEnding));
        }
        for(Map.Entry<Character, TrieNode> entry: remaining.next.entrySet()){
            sub+= entry.getKey();
            getRemainingString(entry.getValue(), sub, result);
            sub = sub.substring(0, sub.length() - 1);
        }
    }
}















/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */