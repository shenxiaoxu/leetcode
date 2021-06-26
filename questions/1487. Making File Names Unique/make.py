'''
Given an array of strings names of size n. You will create n folders in your file system such that, at the ith minute, you will create a folder with the name names[i].

Since two files cannot have the same name, if you enter a folder name which is previously used, the system will have a suffix addition to its name in the form of (k), where, k is the smallest positive integer such that the obtained name remains unique.

Return an array of strings of length n where ans[i] is the actual name the system will assign to the ith folder when you create it.
'''
class Solution:
    def getFolderNames(self, names: List[str]) -> List[str]:
        dict_f = collections.defaultdict(int)
        used = set()
        res = []
        for i, s in enumerate(names):
            current = s      
            fre = dict_f[s]
            while current in used:
                fre+=1
                current = '%s(%d)' % (s, fre)
            dict_f[s] = fre
            used.add(current)
            res.append(current)
        return res
        
        