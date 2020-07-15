//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
//
// 说明:
//
//
// 单词是指由非空格字符组成的字符序列。
// 每个单词的长度大于 0，小于等于 maxWidth。
// 输入单词数组 words 至少包含一个单词。
//
//
// 示例:
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
//
//
// 示例 2:
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。
//     第二行同样为左对齐，这是因为这行只包含一个单词。
//
//
// 示例 3:
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
//
// Related Topics 字符串
package 算法集合51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 贪心
 * 1ma
 * 38.1MB
 */
public class _68_文本左右对齐 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<List<String>> group = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int groupIndex = 0;
        int index = 0;
        int size = 0;
        group.add(new ArrayList<>());
        while(index < words.length){
            size += words[index].length();
            if(size + group.get(groupIndex).size() <= maxWidth){
                group.get(groupIndex).add(words[index]);
                index++;
            }else{
                sizes.add(size - words[index].length());
                size = 0;
                groupIndex++;
                group.add(new ArrayList<>());
            }
        }
        for(List<String> list : group){
            StringBuilder sb = new StringBuilder(maxWidth);
            //最后一行、一行只有一个单词处理
            if(group.indexOf(list) == group.size() - 1 || list.size() == 1){
                for(int i = 0; i < list.size(); i++){
                    if(i != 0){
                        sb.append(" ");
                    }
                    sb.append(list.get(i));
                }
                for(int i = sb.length(); i < maxWidth; i++){
                    sb.append(" ");
                }
            }else {
                //其他行处理
                int sumLen = sizes.get(group.indexOf(list));
                int spaceAvg = (maxWidth - sumLen) / (list.size() - 1);
                int odd = maxWidth - sumLen - spaceAvg * (list.size() - 1);
                for(int i = 0; i < list.size(); i++){
                    if(i == 0){
                        sb.append(list.get(i));
                    }else{
                        int spaceLen = odd > 0 ? spaceAvg + 1 : spaceAvg;
                        for(int j = 0; j < spaceLen; j++){
                            sb.append(" ");
                        }
                        odd--;
                        sb.append(list.get(i));
                    }
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}
