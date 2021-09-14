package sf;

import java.util.*;
import java.util.stream.Collectors;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");

        Department dep3 = new Department(3, 1, "研发中心");
        Department dep8 = new Department(8, 1, "产品部");

        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep7 = new Department(7, 3, "前端研发组");

        Department dep6 = new Department(6, 4, "后端实习生组");


        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);


        List<Department> subDepartments = getSub(3, allDepartment);
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }

    public static List<Department> getSub(int id, List<Department> allDepartment) {
        List<Department> res = new ArrayList<>();
// pid 对应的 子部门
        Map<Integer, List<Department>> pidMap = allDepartment.stream()
                .collect(Collectors.groupingBy(Department::getPid));


        TreeMap<Integer, List<Department>> treeMap = new TreeMap<>(pidMap);
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, List<Department>> entry : treeMap.entrySet()) {
            Integer k = entry.getKey();
            List<Department> value = entry.getValue();
            List<Department> departments;
            if (id == k) {
                departments = pidMap.get(k);
                if (value != null)
                    set.addAll(value.stream().map(Department::getId).collect(Collectors.toSet()));
                res.addAll(departments);
            }
            if (!set.contains(k) && value != null) {
                res.addAll(value);
            }
        }
        return res;
    }

    public static List<Department> get(List<Department> list, List<Department> res, Map<Integer, List<Department>> map) {
        // pid 对应的 子部门
        Map<Integer, List<Department>> pidMap = list.stream()
                .collect(Collectors.groupingBy(Department::getPid));
        for (Map.Entry<Integer, List<Department>> entry : pidMap.entrySet()) {
            Integer k = entry.getKey();
            List<Department> v = entry.getValue();// 4 7
            if (v != null) {
                res.addAll(v);
                for (Department e : v) {
                    List<Department> list2 = map.get(e.getId());
                    if (list2 == null) {
                        List<Department> list1 = get(v, res, map);
                        if (list1 == null)
                            res.addAll(list1);
                    }
                }
            }
        }
        return null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}