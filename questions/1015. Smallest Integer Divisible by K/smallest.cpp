class solution{
public:
	int smallest(int k){
		if(!(k%10 == 1 || k%10 == 3 || k%10 == 7 || k%10 == 9)) return -1;
		set<int> s;
		int prev = 0;
		for(int i = 1; i < k + 1; i++){
			int remain = (prev*10 + 1)%k;
			if(remain == 0) return i;
			if(s.count(remain)) return -1;
			s.insert(remain);
			prev = remain;
		}
		return -1;  
	}
};
