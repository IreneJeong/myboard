package net.developia.restful.board;
//인터페이스를 구현한 서비스

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() throws Exception {
		return boardDAO.getBoardList();
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);
	}
	@Override
	   public void insertArticle(ArticleVO articleVO) throws Exception {
	      boardDAO.insertArticle(articleVO);
	}

	@Override
	public List<ArticleVO> getList(int boa_no) throws Exception {
		return boardDAO.getList(boa_no);
	}

	@Override
	public BoardVO getBoard(int boa_no) throws Exception {
		BoardVO boardVO = boardDAO.getBoard(boa_no);
		if(boardVO==null) {
			throw new RuntimeException("잘못된 게시판 번호입니다.");
		}
		return boardVO;
	}

	@Override
	public ArticleVO getArticle(long art_no) throws Exception {
		ArticleVO articleVO = boardDAO.getArticle(art_no);
		if (articleVO==null) {
			throw new RuntimeException(art_no+" 번호의 글이 없습니다.");
		}
		return articleVO;
	}

	@Override
	public void updateReadcnt(long art_no) throws Exception {
		if (boardDAO.updateReadcnt(art_no)==0) {
			throw new RuntimeException(art_no + "번 글이 존재하지 않습니다.");
		}
	}

	@Override
	public void deleteArticle(ArticleVO articleVO) throws Exception {
		if (boardDAO.deleteArticle(articleVO) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이없습니다. ");
		}
	}

	@Override
	public void updateArticle(ArticleVO articleVO) throws Exception {
		if (boardDAO.updateArticle(articleVO) == 0) {
			throw new RuntimeException("존재하지 않거나 접근 권한이없습니다. ");
		}
	}

}
