public class Solution {
	public String addBinary(String a, String b) {
		if (a == null || b == null) {
			return "";
		}
		int m = a.length();
		int n = b.length();
		int total = Math.max(m, n) + 1;
		int[] ans = new int[total];

		return null;
	}

	public static void main(String[] args) {
		System.out
				.println("SELECT "
						+ "F.SUMMARIZE_TOTAL, "
						+ "F.COUNT_TO_SUMMARIZE,"
						+ "F.ACCOUNTING_TITLE,F.RELATION,F.TERM_ID, "
						+ "S.CUSTOMER_NAME, "
						+ "S.CUSTOMER_ADDRESS, "
						+ "S.TRANSACTION_DETAIL "
						+ "FROM ("
						+ "SELECT "
						+ "SUM(ENDING_BALANCE) SUMMARIZE_TOTAL, "
						+ "COUNT(*) COUNT_TO_SUMMARIZE,"
						+ "ACCOUNTING_TITLE, "
						+ "RELATION, "
						+ "TERM_ID "
						+ "FROM "
						+ "AC_AD_FORM004A "
						+ "WHERE "
						+ "CORP_ID = ? "
						+ "AND ENDING_BALANCE < ? "
						+ " AND RELATION <> 0 "
						+ "AND IS_SUMMARIZED_RECORD = 0 "
						+ "AND TERM_ID IN (?,?) "
						+ "GROUP BY ACCOUNTING_TITLE, RELATION, TERM_ID "
						+ "ORDER BY ACCOUNTING_TITLE, RELATION, TERM_ID "
						+ ") F "
						+ "LEFT JOIN  AC_AD_FORM004A_SUMMARIZED_MST S "
						+ "ON F.ACCOUNTING_TITLE = S.ACCOUNTING_TITLE AND F.RELATION = S.RELATION AND S.CORP_ID = ?");

		System.out
				.println("SELECT "
						+ "F.SUMMARIZE_TOTAL, "
						+ "F.COUNT_TO_SUMMARIZE,"
						+ "F.ACCOUNTING_TITLE,F.TERM_ID, "
						+ "S.CUSTOMER_NAME, "
						+ "S.CUSTOMER_ADDRESS, "
						+ "S.MEMO "
						+ "FROM ("
						+ "SELECT "
						+ "SUM(ENDING_BALANCE) SUMMARIZE_TOTAL, "
						+ "COUNT(*) COUNT_TO_SUMMARIZE,"
						+ "ACCOUNTING_TITLE, "
						+ "TERM_ID "
						+ "FROM "
						+ "AC_AD_FORM009A "
						+ "WHERE "
						+ "CORP_ID = ? "
						+ "AND ENDING_BALANCE < ? "
						+ "AND IS_SUMMARIZED_RECORD = 0 "
						+ "AND TERM_ID IN (?,?) "
						+ "GROUP BY ACCOUNTING_TITLE, TERM_ID "
						+ "ORDER BY ACCOUNTING_TITLE, TERM_ID "
						+ ") F "
						+ "LEFT JOIN  AC_AD_FORM009A_SUMMARIZED_MST S "
						+ "ON F.ACCOUNTING_TITLE = S.ACCOUNTING_TITLE AND S.CORP_ID = ?"

						+ "");
	}
}