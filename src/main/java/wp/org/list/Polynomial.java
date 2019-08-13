package wp.org.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 一元多项式的求解算法
 * 链表数据结构实现
 */
public class Polynomial {
    private List<PolynomialNode> p;

    public void createPolyn(){
        if(null == p){
            p = new LinkedList<PolynomialNode>();
        }
        Scanner in = new Scanner(System.in);
        System.out.println("请输入多项式的系数和指数：");
        int i = 1;

        outter:while (true){
            double coef = 0.0;
            int expn = 0;
            System.out.println("请输入第"+i+"项多项式的系数：");
            if(in.hasNextDouble()) {
                coef = in.nextDouble();
            }else {
                System.out.println("输入的不是数字！");
            }
            System.out.println("请输入第"+i+"项多项式的指数：");
            if(in.hasNextInt()) {
                expn = in.nextInt();
            }else {
                System.out.println("输入的不是数字！");
            }
            p.add(new PolynomialNode(coef, expn));
            System.out.println("是否结束输入：y/n");
            if(in.hasNext()) {
                String end = in.next();

                if (end.equals("y")) {
                    break outter;
                }
            }
            i++;
        }
        System.out.println("是否结束输入：y/n");
//        in.close();
    }

    public int polynomialLentgh(){
        return p.size();
    }

    public List<PolynomialNode> getPolynomial(){
        return p;
    }

    private int comp(PolynomialNode a, PolynomialNode b){
        if(a.getExpn() > b.getExpn()){
            return 1;
        }else if(a.getExpn() == b.getExpn()){
            return 0;
        }else {
            return -1;
        }
    }

    public int addPolynomial(List<PolynomialNode> other){
        List<PolynomialNode> tmp = new LinkedList<>();
        List<PolynomialNode> o = other;
        if(null == other){
            return 2;
        }
        if(null == p){
            tmp.addAll(o.subList(0, o.size()));
            p = tmp;
            return 3;
        }
        if(null != p && null != o){
            int i = 0;
            int j = 0;
            while (i < p.size() && j < o.size()){
                PolynomialNode a = p.get(i);
                PolynomialNode b = o.get(j);
                if(comp(a, b) == 1){
                    tmp.add(b);
                    j++;
                }else if(comp(a, b) == 0){
                    if((a.getCoef() + b.getCoef()) != 0) {
                        tmp.add(new PolynomialNode((a.getCoef() + b.getCoef()), a.getExpn()));
                    }
                    i++;
                    j++;
                }else {
                    tmp.add(a);
                    i++;
                }
            }
            if(!(i == p.size() && j == o.size())){
                if(i != p.size()){
                    tmp.addAll(p.subList(i, p.size()));
                }else {
                    tmp.addAll(o.subList(j, o.size()));
                }
            }
            p = tmp;
            return 1;
        }else {
            return 0;
        }
    }

    public int substractPolynomial(List<PolynomialNode> other){
        List<PolynomialNode> tmp = new LinkedList<>();
        List<PolynomialNode> o = other;
        if(null == other){
            return 2;
        }
        if(null == p){
            for (int k=0;k<o.size();k++){
                tmp.add(new PolynomialNode((-1 * o.get(k).getCoef()), o.get(k).getExpn()));
            }
            p = tmp;
            return 3;
        }
        if(null != p && null != o){
            int i = 0;
            int j = 0;
            while (i < p.size() && j < o.size()){
                PolynomialNode a = p.get(i);
                PolynomialNode b = o.get(j);
                if(comp(a, b) == 1){
                    tmp.add(new PolynomialNode((-1 * b.getCoef()), b.getExpn()));
                    j++;
                }else if(comp(a, b) == 0){
                    if((a.getCoef() - b.getCoef()) != 0) {
                        tmp.add(new PolynomialNode((a.getCoef() - b.getCoef()), a.getExpn()));
                    }
                    i++;
                    j++;
                }else {
                    tmp.add(a);
                    i++;
                }
            }
            if(!(i == p.size() && j == o.size())){
                if(i != p.size()){
                    tmp.addAll(p.subList(i, p.size()));
                }else {
                    for (int k=j;k<o.size();k++){
                        tmp.add(new PolynomialNode((-1 * o.get(k).getCoef()), o.get(k).getExpn()));
                    }
                }
            }
            p = tmp;
            return 1;
        }else {
            return 0;
        }
    }

    public int multiPolynomial(List<PolynomialNode> other){
        Polynomial n = new Polynomial();
        List<PolynomialNode> tmpa = new LinkedList<>();
        for (PolynomialNode a:p) {
            for (PolynomialNode b:other) {
                tmpa.add(a.mutli(b));
            }
            n.addPolynomial(tmpa);
            tmpa.clear();
        }
        p = n.getPolynomial();
        return 1;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (PolynomialNode e:p) {
            sb.append(e.toString());
        }
        return "Polynomial{" +
                "p=" + sb.toString() +
                '}';
    }
}

class PolynomialNode{
    double coef;  //系数
    int expn;  //指数

    PolynomialNode(double coef, int expn){
        this.coef = coef;
        this.expn = expn;
    }

    public PolynomialNode mutli(PolynomialNode o){
        return new PolynomialNode((this.getCoef() * o.getCoef()), (this.getExpn() + o.getExpn()));
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getExpn() {
        return expn;
    }

    public void setExpn(int expn) {
        this.expn = expn;
    }

    public String toString(){
        return "("+coef+","+expn+")";
    }
}
