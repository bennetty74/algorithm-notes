package org.bugkit.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * @author bugkit
 * @since 2021.12.28
 */
class MinStack {

    private int minIndex;
    private List<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        minIndex = -1;
        stack = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if(minIndex == -1){
            minIndex = 0;
        }else if(val < stack.get(minIndex)){
            minIndex = stack.size() - 1;
        }
    }

    public void pop() {
        // 最小元素被移除，重新遍历
        if(minIndex == stack.size() - 1){
            minIndex = 0;
            stack.remove(stack.size() - 1);
            for(int i=0;i<stack.size();i++){
                if(stack.get(i) < stack.get(minIndex)){
                    minIndex = i;
                }
            }
        }else{
            stack.remove(stack.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return stack.get(minIndex);
    }
}
