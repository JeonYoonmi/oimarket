package kr.co.oi.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {

	private static SqlMapClient smc;
	
	static {
		try {
			// 1-1. 문자 인코딩 케릭터 셋 설정
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);

			// 1-2. 환경 설정 파일 읽어올 스트림 객체를 구한다.
			Reader rd = Resources.getResourceAsReader("kr/co/oi/config/SqlMapConfig.xml");

			// 1-3. 스트림 객체를 이용하여 환경 설정 파일을 읽어와 필요한 환경 설정을 진행하고
			// 환경 설정이 완료되면 작성된 SQL문을 호출해서 실행할 수 있는 iBatis객체를 생성한다.
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			rd.close(); // 스트림 객체 닫기
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static SqlMapClient getSqlMapClient() {
		return smc;
	}
	
}