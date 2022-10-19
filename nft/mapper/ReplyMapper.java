package com.nft.mapper;

import com.nft.dto.ReplyVo;

public interface ReplyMapper {
	public int insert(ReplyVo vo);
	
	public ReplyVo read(Long rno); //특정 댓글 읽기
	
	public int delete(int rno);
	
	public int update(ReplyVo reply);
	
	
}
