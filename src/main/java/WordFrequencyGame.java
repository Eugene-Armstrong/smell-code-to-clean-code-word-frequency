import java.util.*;

/**
 * Created by jxzhong on 2018/5/22.
 */
public class WordFrequencyGame {
    public String getResult(String inputStr) {

        if (inputStr.split("\\s+").length == 1) {
            return inputStr + " 1";
        } else {
            //split the input string with 1 to n pieces of spaces
            List<Input> inputList = splitInputs(inputStr);

            //get the map for the next step of sizing the same Input
            Map<String, List<Input>> map = getListMap(inputList);

            List<Word> formattedWord = formatList(map);
            formattedWord.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            return getStrResult(formattedWord);
        }
    }

    private List<Word> formatList(Map<String, List<Input>> map) {
        List<Input> inputList;
        List<Word> list = new ArrayList<>();
        for (Map.Entry<String, List<Input>> entry : map.entrySet()) {
            Word input = new Word(entry.getKey(), entry.getValue().size());
            list.add(input);
        }

        return list;
    }

    private List<Input> splitInputs(String inputStr) {
        String[] arr = inputStr.split("\\s+");

        List<Input> inputList = new ArrayList<>();
        for (String s : arr) {
            Input input = new Input(s,1);
            inputList.add(input);
        }
        return inputList;
    }

    private Map<String, List<Input>> getListMap(List<Input> inputList) {
        Map<String, List<Input>> map = new HashMap<>();
        for (Input input : inputList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(input.getValue())) {
                ArrayList arr = new ArrayList<>();
                arr.add(input);
                map.put(input.getValue(), arr);
            } else {
                map.get(input.getValue()).add(input);
            }
        }
        return map;
    }

    private String getStrResult(List<Word> inputList) {
        StringJoiner joiner = new StringJoiner("\n");
        for (Word w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
        return joiner.toString();
    }
}
