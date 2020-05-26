### 方法重载
  * 注意置换参数顺序制造的方法重载必须要在不同类型的参数之间
  * 返回值类型不同或函数名不同，不能

  1. 计算图形面积的方法重载例子

   ```java  
    
    // 计算矩形面积
    public double area(float a,float b){
        return a*b;
    }

    // 计算三角形面积，参数个数不同，实现了方法 area 的重载
    public double area(float a,float b,float c){
        float d= (a+b+c)/2;
        return Math.sqrt(d*(d-a)*(d-b)*(d-c));
    }

    // 计算边长为整数的矩形面积，参数类型不同，实现了方法 area 的重载  
    public double area(int a,int b){
        return a*b;
    }

    // 计算一边长为整数，一边长为小数的矩形面积，参数类型不同，实现了方法 area 的重载
    public double area(int a,float b){
        return a*b;
    }

    // 计算一边长为整数，一边长为小数的矩形面积，参数顺序不同，实现了方法 area 的重载
    public double area(float a,int b){
        return a*b;
    }  

   ```  
