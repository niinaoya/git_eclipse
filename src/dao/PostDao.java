package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Post;

public class PostDao {
	private static final String url = "jdbc:mysql://localhost:3306/BookManagement?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "ekbr9o1nistr";

	public ArrayList<Post> searchDao(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Post> results = new ArrayList<Post>();

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM Postinfo;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, key);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			while(rs.next()){
				Post Post = new Post(0, null, null);
				Post.setId(rs.getInt("id"));
				Post.setName(rs.getString("name"));
				Post.setContent(rs.getString("content"));

				results.add(Post);

			}

			return results;


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;

	}
	public static ArrayList<Post> deleteDao(int Id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "DELETE FROM Postinfo WHERE id = ?;";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, Id);


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;



	}
	public void insertDao(Post post){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "INSERT INTO Postinfo(content,name) VALUES(?,?);";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, post.getContent());
			pstmt.setString(2, post.getName());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

	}
	public static void updatePost(Post s){

		Connection con = null;
		PreparedStatement pstmt = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pw);

			String sql = "UPDATE Postinfo SET content = ?, name = ? where id = ?;";

			pstmt = con.prepareStatement(sql);


			pstmt.setString(1, s.getContent());
			pstmt.setString(2, s.getName());

			pstmt.executeUpdate();

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑨DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
}