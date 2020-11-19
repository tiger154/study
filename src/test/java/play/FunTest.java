package play;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunTest {
    private static Logger log = LoggerFactory.getLogger(FunTest.class);

    /**
     * Sample planner A
     */
    public static class PlannerA {
        public static int min_repeat_level = 3;
        public static int max_repeat_level = 10;
    }



    @Test
    public void work_flow_recursive_test() {

       int limit = getRandomNumber(PlannerA.min_repeat_level, PlannerA.max_repeat_level);

        work_flow(1, "타겟픽 2021년 개발계획 수립", limit);


    }


    /**
     * 개발일정작성(N, work, limit_n)
     *    N : show how many depth we repeat
     *    work: Name of work
     *    weight: gives limit range(random number) --> Gonna make by human
     *
     *      0) If WBS 작성 완료 && 보고승인 완료
     *          return;
     *          -- It can be infinity loop but I'm gonna give exit condition
     *
     *      1) N 분석 보고
     *      2) N+1 항목 협의
     *      3) f(n+1)
     *
     *      TimeComplexity is O(RandomN)
     * @param n
     */
    public void work_flow(int n, String work, int limit) {

        log.debug("기획자>> {} 차 분석 업무 요청", n);

        // done we assume it pass all process
        if (n == limit) {
            log.debug("{} 업무 완료, 총 {} 회 스프린트 반복 (WBS 작성 완료, 보고승인 완료!)", work, n);
            return;
        }
        // logic run
        log.debug("개발자>>  {} 차 분석 결과 보고", n);
        log.debug("개발자+기획자 >> {} 차 항목 협의", n+1);
        // recursive call
        work_flow(n+1, work, limit);

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }


    /**
     * Sample data
     * 1 - 2 - 7
     *   - 3
     * 4 - 5
     *   - 6
     *
     */
    @Test
    public void extract_root_mcc_test1() {

        // 테스트 트리 데이터 (1,4 is top)
        List<Map<String, List<String>>> compareMccAccountsList = new ArrayList<Map<String, List<String>>>() {{
            add(new HashMap<String, List<String>> () {{ put("1",  Arrays.asList("1","2","3","7"));}});
            add(new HashMap<String, List<String>> () {{ put("2",  Arrays.asList("2","7"));}});
            add(new HashMap<String, List<String>> () {{ put("3",  Arrays.asList("3"));}});
            add(new HashMap<String, List<String>> () {{ put("4",  Arrays.asList("4","5","6"));}});
            add(new HashMap<String, List<String>> () {{ put("5",  Arrays.asList("5"));}});
            add(new HashMap<String, List<String>> () {{ put("6",  Arrays.asList("6"));}});
            add(new HashMap<String, List<String>> () {{ put("7",  Arrays.asList("7"));}});
        }};

        // 테스트 트리 root 데이터
        HashMap<String, List<String>> root = new HashMap<String, List<String>> () {{
            put("1",  Arrays.asList("1","2","3","7"));
            put("4",  Arrays.asList("4","5","6"));
        }};

        // 테스트 정상 여부
        Assert.assertEquals(root, extract_root_mcc(compareMccAccountsList));

    }

    /**
     * Sample data 순서 무작위 변경 시 에러여부
     * 1 - 2 - 7
     *   - 3
     * 4 - 5
     *   - 6
     * 8
     */
    @Test
    public void extract_root_mcc_test2() {

        // 테스트 트리 데이터 (1,4 is top)
        List<Map<String, List<String>>> compareMccAccountsList = new ArrayList<Map<String, List<String>>>() {{

            add(new HashMap<String, List<String>> () {{ put("5",  Arrays.asList("5"));}});
            add(new HashMap<String, List<String>> () {{ put("2",  Arrays.asList("2","7"));}});
            add(new HashMap<String, List<String>> () {{ put("1",  Arrays.asList("1","2","3","7"));}});
            add(new HashMap<String, List<String>> () {{ put("6",  Arrays.asList("6"));}});
            add(new HashMap<String, List<String>> () {{ put("3",  Arrays.asList("3"));}});
            add(new HashMap<String, List<String>> () {{ put("4",  Arrays.asList("4","5","6"));}});
            add(new HashMap<String, List<String>> () {{ put("7",  Arrays.asList("7"));}});
        }};

        // 테스트 트리 root 데이터
        HashMap<String, List<String>> root = new HashMap<String, List<String>> () {{
            put("1",  Arrays.asList("1","2","3","7"));
            put("4",  Arrays.asList("4","5","6"));
        }};

        // 테스트 정상 여부
        Assert.assertEquals(root, extract_root_mcc(compareMccAccountsList));

    }


    /**
     * I think this need to have strong test cases
     *
     * Idea is simple check if there current element is a child of other then remove it
     *
     *
     * - 변수 설명
     *
     *  (Map<String, List<String>>) finalMccAccountsMap : 최종 결과 셋. 인자로 받은 데이터를 형변환 하여 미리 저장 해놓는다. 추후 최상위 트리가 아니라고 판명된놈들을 제거해준다.
     *  (Map<String, List<String>>) left  (i)  : 기준 인덱스 값으로 right 가 전체 스캔 완료시까지 고정됨. 키: 광고계정 아이디, 값: 본인포함 자식 광고계정 아이디 리스트
     *  (Map<String, List<String>>) right (j)  : 계속 움직이며 left 와 비교 하는 인덱스 키 : 광고계정 아이디, 값: 본인포함 자식 광고계정 아이디 리스트
     *
     * - 로직 설명
     *
     *  1) 각 인덱스(i,j) 기준 left, right 의 키,값 추출
     *  2) left 와 right 의 값 을 비교하여, 교집합 존재 여부 점검
     *  3) 만약 교집합 존재한다면, left 와 right 의 값(list) 의 크기 비교.
     *    - 값이 작은 놈을 최종 결과 셋에서 제거한다.
     *
     *
     * - 전제
     *   1) 각 row 는 본인 포함 자식 트리를 가지고 있다.
     *   2) 각 row 는 유니크 하다.
     *   3) 정렬이 되어있지 않다.
     *
     * @param list
     */
    public Map<String, List<String>> extract_root_mcc(List<Map<String, List<String>>> list) {

        int index = 0;
        Map<String, List<String>> finalMccAccountsMap = new HashMap<>(); // map is fast!

        // 1. 최종 데이터에 대상 데이터 일괄 입력(타입 변경)
        //   List<Map<String, List<String>>> --> Map<String, List<String>> 으로 변경
        list.stream().forEach( x -> {
            String key = (String) x.keySet().toArray()[0];
            log.debug("hey");
            finalMccAccountsMap.put(key, x.get(key));
        });



        // 가우스 법칙( N * (N + 1) / 2 ) loop 진행. 시간복잡도는 O(N^2)
        //
        for (int i = 0; i < list.size(); i++) {

            // 1) 왼쪽 기준 인덱스 가져오기
            //   - 맵에서 각각 key, value 추출
            Map<String, List<String>> left = list.get(i);
            String left_key =  (String) left.keySet().toArray()[0];
            List<String> left_list = left.get(left_key);

            for (int j = i+1; j < list.size(); j++) {
                // If from i it has duplicate remove it
                log.debug("i:{}, j:{},  count!: {}", i, j, index++);

                // 2) 오른쪽 무빙 인덱스 가져오기
                //   - 맵에서 각각 key, value 추출
                Map<String, List<String>> right = list.get(j);
                String right_key =  (String) right.keySet().toArray()[0];
                List<String> right_list = right.get(right_key);

                // 3) 두개의 값이 교집합 존재하는지 체크
                Set<String> result = left_list.stream().distinct().filter(right_list::contains).collect(Collectors.toSet());

                // 4) 교집합 존재하면 최종 결과 셋에서 제거한다.
                //   - 이때 두(left,right) 의 값중 작은 놈을 찾아서 제거한다.
                if (result != null && result.size() > 0) {
                    String smaller_key = (left_list.size() > right_list.size()) ? right_key : left_key;
                    finalMccAccountsMap.remove(smaller_key);
                }
            }
        }

        return finalMccAccountsMap;
    }



}
