package shiyan1;
import java.util.Scanner;
import java.io .FileInputStream;
import java.util.Random;
import java.io.File;

public class test {
	private static int N = 500;
	private static graphInfo g=new graphInfo();
	private static shortestpathInfo si=new shortestpathInfo();
	private static RandomInfo ri=new RandomInfo();
	private static newtextInfo ni=new newtextInfo();
	private static Scanner scan = new Scanner(System.in );
	public static class contextGraphOutput{//新文本生成图
	    public void main(String[] word1,String[] word2,String[] temp,int tcount) {
            int[][] flagedge=new int[N][N];
            int ei=0,ej=0,i=0,j=0,ti=0,k;
            for(k=0;k<tcount;k++) {
                for(j=0;j<g.wordnum;j++) {
                    if(temp[k].equals(g.word[j])) {
                        ti=j;
                    }
                    if(word1[k].equals(g.word[j])) {
                        ei=j;
                    }
                    if(word2[k].equals(g.word[j])) {
                        ej=j;
                    }
                }
                flagedge[ei][ti]=1;
                flagedge[ti][ej]=1;
            }
            
            
            Graphviz gv = new Graphviz();
            gv.addln(gv.start_graph());
            
            for(i=0;i<g.wordnum;i++)
            {
                for(j=0;j<g.wordnum;j++)
                {
                    if(g.edge[i][j]<N)
                    {
                        if(flagedge[i][j]==0) {
                            gv.addln(g.word[i]+"->"+g.word[j]+"[label="+g.edge[i][j]+"]");
                        }
                        else {
                            gv.addln(g.word[i]+"[color=red]");
                            gv.addln(g.word[j]+"[color=red]");
                            gv.addln(g.word[ti]+"[color=red]");
                            gv.addln(g.word[i]+"->"+g.word[j]+"[color=orange,label="+g.edge[i][j]+"]");
                            //System.out.println("哈哈哈");
                        }
                    }
                }
            }
            gv.addln(gv.end_graph());
        //  System.out.println(gv.getDotSource());
            gv.increaseDpi();   // 106 dpi
            String type = "png";
            String repesentationType= "dot";
            File out = new File("D:/lab1test/graphbridge." + type);    // Windows
            gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
        }
	}
	public static class graphOutput{//graphviz图输出
		public void main() {
			int i,j;		
			Graphviz gv = new Graphviz();
			gv.addln(gv.start_graph());
			for(i=0;i<g.wordnum;i++)
			{
				for(j=0;j<g.wordnum;j++)
				{
					if(g.edge[i][j]<N)
					{
						gv.addln(g.word[i]+"->"+g.word[j]+"[label="+g.edge[i][j]+"]");
					}
				}
			}
			gv.addln(gv.end_graph());
			gv.increaseDpi();   // 106 dpi
			String type = "png";
			String repesentationType= "dot";
			File out = new File("D:/lab1test/graph." + type);    // Windows
			gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
		}
	}
	public static class graphInfo {		
		public int wordnum;//单词个数
		public int[] edgenum=new int[N];//边条数
		public String[] word=new String[N];//单词数组
		public int[][] edge=new int[N][N];//边的二维数组
		public int getWordnum() {
			return wordnum;
		}
		public void setWordnum(int wordnum) {
			this.wordnum = wordnum;
		}
		public int[] getEdgenum() {
			return edgenum;
		}
		public void setEdgenum(int[] edgenum) {
			this.edgenum = edgenum;
		}
		public String[] getWord() {
			return word;
		}
		public void setWord(String[] word) {
			this.word = word;
		}
		public int[][] getEdge() {
			return edge;
		}
		public void setEdge(int[][] edge) {
			this.edge = edge;
		}	
	}
	public static class shortestpathInfo{
		private int path[][]=new int[N][N];
		private int dis[][]=new int[N][N];
		public int[][] getPath() {
			return path;
		}
		public void setPath(int[][] path) {
			this.path = path;
		}
		public int[][] getDis() {
			return dis;
		}
		public void setDis(int[][] dis) {
			this.dis = dis;
		}
		
	}
	public static class RandomInfo{
		private int index[]= new int[N];
		private String str;
		public int[] getIndex() {
			return index;
		}
		public void setIndex(int[] index) {
			this.index = index;
		}
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		
	}
	public static class newtextInfo{
		private String newtext;
		private int word1[]=new int[N];
		private int word2[]=new int[N];
		private int bridge[]=new int[N];
		public void init() {
			for(int i=0;i<N;i++) {
				word1[i]=-1;
				word2[i]=-1;
				bridge[i]=-1;
			}
		}		
		public String getNewtext() {
			return newtext;
		}
		public void setNewtext(String newtext) {
			this.newtext = newtext;
		}
		public int[] getWord1() {
			return word1;
		}
		public void setWord1(int word1) {
			for(int i=0;i<N;i++) {
				if(this.word1[i]==-1) {
					this.word1[i]=word1;
					break;
				}
			}
		}
		public int[] getWord2() {
			return word2;
		}
		public void setWord2(int word2) {
			for(int i=0;i<N;i++) {
				if(this.word2[i]==-1) {
					this.word2[i]=word2;
					break;
				}
			}
		}
		public int[] getBridge() {
			return bridge;
		}
		public void setBridge(int bridge) {
			for(int i=0;i<N;i++) {
				if(this.bridge[i]==-1) {
					this.bridge[i]=bridge;
					break;
				}
			}
		}
		
	}
	public static class location{
		private String path;
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public void out(){
			//Scanner scan = new Scanner(System.in );
			System.out.println("请输入要读取的文件路径");
			path = scan.nextLine();
			//scan.close();
		}
	}
	public static class randomOrnot{
		private String str;
		public String flag;
		public String getFlag() {
			return flag;
		}
		public void setFlag(String flag) {
			this.flag = flag;
		}
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		public void in() {
		//	Scanner scan = new Scanner(System.in );
			System.out.print("按回车键重新进行随机游走，按q退出");
			flag=scan.nextLine();
		//	scan.close();
		}
		public void out() {
			System.out.println(str);
		}
		
	}
	public static class bridgeinput{
		private String word1;
		private String word2;
		private String bridge;
		public String getWord1() {
			return word1;
		}
		public void setWord1(String word1) {
			this.word1 = word1;
		}
		public String getWord2() {
			return word2;
		}
		public void setWord2(String word2) {
			this.word2 = word2;
		}
		public String getBridge() {
			return bridge;
		}
		public void setBridge(String bridge) {
			this.bridge = bridge;
		}
		public void in() {

			//Scanner scan = new Scanner(System.in );
			System.out.println("请输入单词");
			word1 = scan.nextLine();
			word2 = scan.nextLine();
			//scan.close();
			
		}
		public void out(){
			if(bridge==null) {
				System.out.println("No "+ word1 +" or "+ word2 +" in this graph");
			}
			else if(bridge.equals(" ")) {
				System.out.println("No bridge words from "+word1+" to "+word2);
			}
			else {
				System.out.println("The bridge words from "+word1+" to "+word2+" are :"+bridge  );
			}
		}
	}
	public static class shortestInput{
		private String word1;
		private String word2;
		private int dis;
		private String path;
		public String getWord1() {
			return word1;
		}
		public void setWord1(String word1) {
			this.word1 = word1;
		}
		public String getWord2() {
			return word2;
		}
		public void setWord2(String word2) {
			this.word2 = word2;
		}
		public int getDis() {
			return dis;
		}
		public void setDis(int dis) {
			this.dis = dis;
		}
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}	
		public void in() {
			//Scanner scan = new Scanner(System.in );
			System.out.println("请输入两个单词以生成最短路径");
			word1 = scan.nextLine();
			word2 = scan.nextLine();
			//scan.close();
		}
		public void out() {
			if(path==null) {
				System.out.println(word1+" 到 "+word2+" 没有路");
			}
			else if(path.equals(" ")) {
				System.out.println("No "+ word1 +" or "+ word2 +" in this graph");
			}
			else {
				System.out.println(word1+" 到 "+word2+" 的最短路径长度为："+dis);
				
			}
				
		}
	}
	public static class contextInput{
		private String text;
		private String newtext;
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public String getNewtext() {
			return newtext;
		}
		public void setNewtext(String newtext) {
			this.newtext = newtext;
		}
		public void in() {
		//	Scanner scan = new Scanner(System.in );
			System.out.println("请输入新的一句话");
			text = scan.nextLine();
		//	scan.close();
		}
		public void out() {
			System.out.println("新生成的文本是：");
			System.out.println(newtext);
		}
	}
	public static class createGraph{	
		private String filepath;
		
		public void inout() {
			location loca=new location();
			loca.out();
			filepath=loca.getPath();
			this.main();
		}
		public void main() {
			try {
				FileInputStream in= new FileInputStream(filepath);
				int size=in.available();
				int prei=0;
				byte[] buffer = new byte[size];
				int i=0,j=0;
				int flag=-1;
				String[] wordt=new String[N];
				in.read(buffer);
				in.close();
				String str=new String(buffer,"GB2312");
				str=str.toLowerCase();
				
				for(i=0;i<127;i++)
				{
					if(i<65 || i>122 || (i>90 && i<97))
						str=str.replace((char)i,' ');
				}
			//	System.out.println(str);
				wordt=str.split("\\s+");
				for(i=0;i<wordt.length;i++) {
					flag=-1;
					for(j=0;j<i;j++) {
						if(wordt[i].equals(g.word[j])) {
							flag=j;
							break;
						}
					}
					if(flag==-1){
						if(i!=0) {
							
							if(g.edge[prei][g.wordnum]==0) {
								g.edgenum[prei]++;
							}
							g.edge[prei][g.wordnum]++;
						}
						prei=g.wordnum;
						g.word[g.wordnum]=wordt[i];
						g.wordnum++;
					}
					else {
						if(g.edge[prei][flag]==0) {
							g.edgenum[prei]++;
						}
						g.edge[prei][flag]++;
						prei=flag;
					}
				}
				for(i=0;i<g.wordnum;i++) {
					for(j=0;j<g.wordnum;j++) {
						if(g.edge[i][j]==0) {
							g.edge[i][j]=N;
						}
					}
				}
			}catch(Exception e) {
				System.out.println("读取文件失败！");
			}
		}
		
	}
	public static class random{
		private randomOrnot rornot=new randomOrnot();
		private String str = "";
		public void inout() {
			do{
				rornot.in();
				rornot.setStr(this.main());
				rornot.out();				
			}while((rornot.flag).equals("q")==false) ;
		}
		public String main() {
			
			int[] strword = new int[N];
			Random rand = new Random();
			int i,j,k,prei;
			int count=0;
			int countword=0;
			int flag=1;
			i=rand.nextInt(g.wordnum);
			prei=i;
			while(g.edgenum[i]!=0 && flag==1)
			{
				for(k=1;k<countword;k++)
				{
					if(strword[k]==i && prei==strword[k-1] && countword!=0)
					{
						flag=0;
						break;
					}
				}
				strword[countword]=i;
				countword++;
				if(flag==1)
				{
					j=rand.nextInt(g.edgenum[i]);
					count=0;
					for(k=0;k<g.wordnum;k++)
					{
						if(g.edge[i][k]<N)
						{
							count++;
							if(count-1==j)
								break;
						}
					}
					if(g.edge[i][k]<N) {
						prei=i;
						i=k;
					}
				}
			}
			for(j=0;j<countword;j++)
			{
				str=str+g.word[strword[j]]+" ";
			}
			
			if(g.edgenum[i]==0)
			{
				str=str+g.word[i];
			}
			return str;
		}
	}
	public static class bridge{
		private bridgeinput b=new bridgeinput();
		public void inout() {
			b.in();
			b.setBridge(this.main(b.getWord1(), b.getWord2()));
			b.out();
		}
		public String main(String word1,String word2) {
			int i,j;
			int a=-1;
			int b=-1;
			int count=0;
			int flag1 = -1;
			int flag = -1;
			String str="";
			String bridge[] = new String[N];
			for(i=0;i<g.wordnum;i++) {
				if(g.word[i].equals(word1)) {
					a = i;
					flag = 1;
				}
				if(g.word[i].equals(word2)) {
					b = i;
					flag1 = 1;
				}
			}
			if (flag == -1 || flag1 == -1) {
				return null;
			}
			for(i=0;i<=g.wordnum;i++) {
				flag=flag1=-1;
				if(i!=a && i!=b) {
					for(j=0;j<g.edgenum[a];j++) {
						if(g.edge[a][i]<N) {
							flag = 1;
						}
					}
					for(j=1;j<=g.edgenum[i];j++) {
						if(g.edge[i][b]<N) {
							flag1 = 1;
						}
					} 
					if(flag==1 && flag1==1) {
						bridge[count]=g.word[i];
						count++;
					}
				}
			}
			if(count==0) {
				return " ";
			}
			else {
				for(i=0;i<count;i++) {
					str=str+bridge[i]+" ";
				}
			}
			return str;
		}
	}
	public static class shortestPath{
		private shortestInput s=new shortestInput();
		public void inout() {
			s.in();
			s.setPath(this.main(s.getWord1(), s.getWord2()));
			s.out();
		}
		public String picture_new(int[][] path,int a,int b)
		{
			int i,j;
			String str="";
			int[][] flag=new int[N][N];
			Graphviz gv = new Graphviz();
            gv.addln(gv.start_graph());
			i=a;
			str=g.word[a];
			while(i!=b) {
				str=str+g.word[path[i][b]];
				flag[i][path[i][b]]=1;
				i=path[i][b];
			}
			for(i=0;i<g.wordnum;i++)
            {
                for(j=0;j<g.wordnum;j++)
                {
                    if(g.edge[i][j]<N)
                    {
                        if(flag[i][j]==0) {
                            gv.addln(g.word[i]+"->"+g.word[j]+"[label="+g.edge[i][j]+"]");
                        }
                        else {
                            gv.addln(g.word[i]+"->"+g.word[j]+"[color=blue,label="+g.edge[i][j]+"]");
                            
                        }
                    }
                }
            }
            gv.addln(gv.end_graph());
            //System.out.println(gv.getDotSource());
            gv.increaseDpi();   // 106 dpi
            String type = "png";
            String repesentationType= "dot";
            File out = new File("D:/lab1test/graphnew." + type);    // Windows
            gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
			return str;
		}
		public String main(String word1,String word2) {
			int i,j,k,a=-1,b=-1;
			int flag=-1,flag1=-1;
			int path[][]=new int[N][N];
			int dis[][]=new int[N][N];
			String str="";
			for(i=0;i<g.wordnum;i++) {
				if(g.word[i].equals(word1)) {
					a = i;
					flag = 1;
				}
				if(g.word[i].equals(word2)) {
					b = i;
					flag1 = 1;
				}
			}
			if (flag == -1 || flag1 == -1) {
				System.out.println("No "+ word1 +" or "+ word2 +" in this graph");
				return " ";
			}
			for(i=0;i<g.wordnum;i++) {
				for(j=0;j<g.wordnum;j++) {
					path[i][j]=j;
					dis[i][j]=g.edge[i][j];
				}			
			}
			for(k=0;k<g.wordnum;k++) {
				for(i=0;i<g.wordnum;i++) {
					for(j=0;j<g.wordnum;j++) {
						if(dis[i][k]+dis[k][j]<dis[i][j]) {
							dis[i][j]=dis[i][k]+dis[k][j];
							path[i][j]=path[i][k];
						}
					}
				}
			}
			s.setDis(dis[a][b]);
			if(dis[a][b]<N) {
				str=this.picture_new(path, a, b);
				System.out.println(str);
				return str;
			}
			else {
				return null;
			}
		}
	}
	public static class newText{
		private contextInput c=new contextInput();
		public void inout(){
			c.in();
			c.setNewtext(this.main(c.getText()));
			c.out();
		}
		public String main(String input) {
			String temp;
			bridge bb=new bridge();
			String[] bri=new String[N];
			int start=0;
			int i;
			String[] word1=new String[N],word2=new String[N],ttemp=new String[N];
			int tcount=0;
			String str="";
			String newtext[] = new String[N];
			newtext=input.split(" ");
			for(i=0;i<newtext.length -1;i++) {
				temp=bb.main(newtext[i], newtext[i+1]);
				if(temp != null && temp.equals(" ")==false) {
					
					bri=temp.split(" ");
					temp=bri[0];
					word1[tcount]=newtext[i];
					word2[tcount]=newtext[i+1];
					ttemp[tcount]=temp;
					tcount++;
					
					for(int j=start;j<=i;j++) {
						str=str+newtext[j]+" ";
					}
					str=str+temp+" ";
					start = i+1;
				}
			}	
			contextGraphOutput cgo= new contextGraphOutput();
			cgo.main(word1,word2,ttemp,tcount);
			for(i=start;i<newtext.length;i++) {
				str=str+newtext[i]+" ";
			}
			return str;
		}
	}
	public static void main(String[] args) {
		createGraph cg=new createGraph();
		cg.inout();
		graphOutput go=new graphOutput();
		go.main();
		bridge b = new bridge();
		b.inout();
		newText nt = new newText();
		nt.inout();
		shortestPath sp = new shortestPath();
		sp.inout();
		random r=new random();
		r.inout();
		scan.close();
	}
}
