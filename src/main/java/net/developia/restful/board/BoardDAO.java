package net.developia.restful.board;

import java.util.List;

public interface BoardDAO {

   List<BoardVO> getBoardList() throws Exception;

   void insertBoard(BoardVO boardVO) throws Exception;

   List<ArticleVO> getList(int boa_no)throws Exception;

   BoardVO getBoard(int boa_no)throws Exception;
	
   void insertArticle(ArticleVO articleVO)throws Exception;

   ArticleVO getArticle(long art_no)throws Exception;

   int updateReadcnt(long art_no)throws Exception;

   int deleteArticle(ArticleVO articleVO)throws Exception;

   int updateArticle(ArticleVO articleVO)throws Exception;


}