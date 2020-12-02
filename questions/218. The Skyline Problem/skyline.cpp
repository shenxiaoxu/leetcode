#include <vector>
#include <set>

using namespace std;

class Solution{
public:	
	vector<vector<int> > skyline(vector<vector<int> >& buildings){
		vector<pair<int, int> > events;
		vector<vector<int> > res;
		for(auto b: buildings){
			events.push_back(make_pair(b[0], -b[2]));
			events.push_back(make_pair(b[1], b[2]));
		}
		sort(events.begin(), events.end());
		multiset<int> mset;
		int cur, prev = 0;
		for(auto e: events){
			if(e.second < 0){
				mset.insert(-e.second);
			}else{
				mset.erase(mset.find(e.second));
			}
			cur = *mset.rbegin();
			if(cur != prev){
				prev = cur;
				res.push_back({e.first, cur});
			}
		}
		return res;
	}

};
