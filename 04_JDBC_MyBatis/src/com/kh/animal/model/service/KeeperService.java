package com.kh.animal.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.animal.common.Template;
import com.kh.animal.model.dao.KeeperDao;
import com.kh.animal.model.dto.AnimalDto;
import com.kh.animal.model.dto.KeeperDto;

public class KeeperService {

	public List<KeeperDto> selectKeeperAndAnimals(){
		SqlSession session = Template.getSqlSession();
		
		//쿼리 1번 - 사육사 전체 조회
		List<KeeperDto> keepers = new KeeperDao().selectKeeperAndAnimals(session);
		//쿼리 2번 - where 사육사 번호인 애니멀들을 조회
		for(KeeperDto keeper : keepers) {
			List<AnimalDto> animals = new KeeperDao().selectAnimalList(session, keeper.getKeeperId());
			keeper.setAnimals(animals);
		}
	
		// 쿼리를 10번을 사용했다
		/*성능 이슈
		 * 
		 * 시간!
		 * 쿼리 실행시간 0.1ms
		 * +
		 * 네트워크왕복 (Round Trip) 
		 * 자바서버 <-> DB서버 
		 * -> 시간이 소요 -> 0.5~2 ms -> 수십 ms
		 * 
		 * SQL파싱 + 실행계획 수립 -> DB가 SQL받아서 분석하는 비용
		 * + 커넨션 점유 -> 쿼리가 전부 끝날 때 까지 커넥션을 계속 붙잡고 있어야 함

		 *시나리오 사육사가 100명, 
		 *한 번에 사육사 + 사육사 담당 동물목록 조회 DB커넥션 풀 20개
		 *
		 *
		 *조인을 활용해서 함께 출력해버린다.
		 */
		session.close();
		return keepers;
		
	}
	
	public List<KeeperDto> findKeeperAndAnimals() {
		SqlSession session = Template.getSqlSession();
		List<KeeperDto> keepers = new KeeperDao().findKeeperAndAnimals(session);
		session.close();
		return keepers;
		
	}
	
	public List<KeeperDto> selectKeeperByCondition(Map<String,String> arguments) {
		SqlSession session = Template.getSqlSession();
		List<KeeperDto> keepers = new KeeperDao().selectKeeperByCondition(session, arguments);
		session.close();
		return keepers;
	}
	


}
