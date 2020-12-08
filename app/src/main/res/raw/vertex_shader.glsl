/*
* vec4 包含4个分量，x,y,z,w ，其中前三个是三维坐标，w是特殊坐标，后面讲
* 定点的几个属性，比如颜色和位置，都是放在 attribute 里面
*/
attribute vec4 a_Position;

//着色器的入口
void main(){
    gl_Position = a_Position;
}