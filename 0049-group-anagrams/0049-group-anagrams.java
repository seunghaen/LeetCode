class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> answerMap = new HashMap<>(); //정렬된 문자열을 키, 해당 문자열의 Anagram들을 담을 List를 value로 담을 Map을 선언

        
        for(String str : strs){  //주어진 모든 문자열들에 대해서
        
            String key = sortString(str); //주어진 문자열을 정렬하고, 이를 key로 사용한다.

            if(!answerMap.containsKey(key)){ //answerMap에 key가 존재하지 않는다면
                List<String> anagramList = new ArrayList<>(); 
                anagramList.add(str);
                answerMap.put(key,anagramList); //str을 정렬한 문자열을 키로, str을 하나 담은 List를 value로 넣는다.
            }
            else{ //answerMap에 key가 존재하면
                answerMap.get(key).add(str); //key를 이용하여 List를 get하고, 그 List에 해당 문자열인 str을 넣는다.
            }
        }
        
        List<List<String>> answer = new ArrayList<>(); //정답으로 반환할 List를 초기화
        
        for(List<String> anagramList: answerMap.values()){
            answer.add(anagramList); //answerMap의 value들로 담은 모든 List들을 정답 리스트에 넣는다.
        }

        return answer;
    }


    //문자열을 순서대로 정렬하는 메서드
    public String sortString(String str){
        char[] chars = str.toCharArray(); //주어진 문자열을 char[] 타입의 배열로 전환
        Arrays.sort(chars); //배열 정렬
        return new String(chars); //다시 String 타입으로 전환 후 반환
    }
}