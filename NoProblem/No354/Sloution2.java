class Solution {

    public int maxEnvelopes(int[][] envelopes) {
        //边界情况
        if (envelopes.length == 0) {
            return 0;
        }
        
        int n = envelopes.length;
        //按照envelopes[][0]升序 envelopes[][1]降序的规则排序数组
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        //dp table 只存贮envelopes[][1]
        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);

        // 依次添加元素
        for (int i = 1; i < n; ++i) {
            //当前值的envelopes[][1]
            int num = envelopes[i][1];

            //如果大于了最后一个值，说明当前的envelopes[][0] 一定是大于最后一个元素的envelopes[][0] 
            //且envelopes[][1] 也一定大于之前的 envelopes[][1]，所以此时出现的一定是长宽都比之大的元素
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
            //进入这一个条件有两个可能：
            //1.当前的envelopes[][0] == 最后一个元素的envelopes[][0]  但 当前的envelopes[][1] < 最后一个元素的envelopes[][1]
            //2.当前的envelopes[][0] > 最后一个元素的envelopes[][0]   但 当前的envelopes[][1] < 最后一个元素的envelopes[][1]

            //此时其实可以按照二分查找推测出一些东西，最后一个元素的 envelopes[][1] 一定是在envelopes[][0]相同情况下的大于前一个envelopes[][1]的前提下的最小值
            //因为如果我们按照这个推测会发现，假设前一个是[5,4] 最后一个是[6,7] 当前是[6,5] 那么5最后肯定会把7覆盖掉（因为List 内容为[4, 7]最后返回的下标一定是7所在的下标）
            //假设下一个数据是[6, 1]我们可以知道是，不能用在我们的最长序列里面的，所以他会按照规则覆盖掉，所能覆盖的信封中最大只的位置构建新的序列，在这种情况下，没有超出原有序列时
            //不会对现有序列产生任何影响，相当于同时维护了第一长的序列 和 第二长的序列（秒啊！）
            //总之得自己理解，建议先看看最长子序列 的 二分查找，理解起来会更容易
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    //二分查找没啥说的
    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
