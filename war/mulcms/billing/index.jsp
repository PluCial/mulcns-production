<%@page pageEncoding="UTF-8" isELIgnored="false" session="false" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@ page import="com.plucial.mulcms.App" %>
<%@ page import="com.plucial.mulcms.model.*" %>
<%@ page import="com.plucial.mulcms.model.assets.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="com.plucial.global.Lang" %>
<%
List<Page> pageList = (List<Page>) request.getAttribute("pageList");
Date freePeriodDate = (Date) request.getAttribute("freePeriodDate");

SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日(E曜日) HH:mm");
NumberFormat nfCur = NumberFormat.getNumberInstance();
String appId = (String) request.getAttribute("appId");

%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/mulcms/includes/html_head.jsp" />
	<style>
	.box-header {
		padding-bottom: 0;
	}
	.box-body {
		padding-top: 0;
	}
	.page-info {
		padding-top: 10px;
	}
	</style>
</head>
<body class="skin-blue layout-top-nav">
	<div class="wrapper">
		<!-- site-header -->
		<jsp:include page="/mulcms/includes/site_header.jsp" />
		<!-- /site-header -->


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">

	        <!-- Main content -->
			<section class="content-header">
			</section><!-- /.content -->
			<!-- /.content -->

			<section class="invoice">
				<!-- title row -->
				<div class="row">
					<div class="col-xs-12">
						<h2 class="page-header">
							<i class="fa fa-credit-card"></i> <b>MulCMS</b> ライセンスの購入
						</h2>
					</div><!-- /.col -->
				</div>

				<div class="row">
					<!-- accepted payments column -->
					<div class="col-md-2">
						<p class="lead">お支払い方法:</p>
						<i class="fa fa-cc-paypal" style="font-size: 8em;"></i>
					</div><!-- /.col -->
					<div class="col-md-2 invoice-col">
						<p class="lead">お支払い先:</p>
						<b>株式会社プラシャル</b><br/>
						<b><a href="http://inc.plucial.com/ja/" target="_blank">inc.plucial.com <i class="fa fa-external-link"></i></a></b><br/>
						<br/>
						<a href="http://mulcms.plucial.com/ja/info/agreement.html" target="_blank">利用規約<i class="fa fa-external-link"></i></a><br/>
						<a href="http://mulcms.plucial.com/ja/info/sctl.html" target="_blank">特定商取引法に基づく表記<i class="fa fa-external-link"></i></a><br/>
					</div><!-- /.col -->
					<div class="col-md-4 col-md-offset-1">
						<p class="lead">お支払い詳細:</p>
						<div class="table-responsive">
							<table class="table">
								<tr>
									<th style="width:50%">ライセンス:</th>
									<td>¥ <%=nfCur.format((int)App.AMOUNT) %></td>
								</tr>
								<tr>
									<th>消費税 (8%)</th>
									<td>¥ <%=nfCur.format((int)App.AMOUNT * 0.08) %></td>
								</tr>
								<tr>
									<th>合計金額:</th>
									<td>¥ <%=nfCur.format((int)App.AMOUNT * 1.08) %></td>
								</tr>
							</table>
						</div>
					</div><!-- /.col -->
					<div class="col-md-3">
						<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
							<i class="icon fa fa-warning"></i> お支払いすることにより、本ソフトウェアの提供機能などを十分に理解し、<a href="http://mulcms.plucial.com/ja/info/agreement.html" target="_blank">利用規約 <i class="fa fa-external-link"></i></a>に同意したこととなります。また、一度お支払いするとお支払い頂いた金額を返金することができません。<br />
							また、MulCMSはGoogle Cloude Platformを利用しているため、利用量に応じてGoogleに対して支払いが発生することがあります。詳細は<a href="https://cloud.google.com/?hl=ja" target="_blank">Google Cloude Platform <i class="fa fa-external-link"></i></a>をご確認ください。
						</p>
					</div><!-- /.col -->
				</div><!-- /.row -->
				<hr />
				<!-- this row will not appear when printing -->
				<div class="row no-print">
					<div class="col-xs-12">
						<a class="btn btn-primary btn-lg pull-right" href="/mulcms/billing/billingEntry"><i class="fa fa-credit-card"></i> お支払い</a>
					</div>
				</div>
			</section><!-- /.content -->

			<div class="pad margin no-print">
				<div class="callout callout-info" style="margin-bottom: 0!important;">
					<h4><i class="fa fa-info"></i> Note:</h4>
					PayPalアカウントをお持ちでない、もしくはお持ちのPayPalアカウントの本人確認処理が未完了で限度額によりお支払いできない場合は、銀行振込によるライセンス取得もご利用頂けます。<br />
					銀行振込によるライセンス取得をご希望の場合は info@plucial.com へご連絡ください。<br /><br />
<pre>
<b>メール本文に必ず以下の内容をコピーして貼り付けてください。</b>

project_id:<%=appId %>
</pre>
				</div>
			</div>
		</div><!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<jsp:include page="/mulcms/includes/control_sidebar.jsp" />
		<!-- /.control-sidebar -->

		<!-- page footer -->
	    <jsp:include page="/mulcms/includes/site_footer.jsp" />
		<!-- /page footer -->

		<!-- Add the sidebar's background. This div must be placed
	           immediately after the control sidebar -->
		<div class='control-sidebar-bg'></div>
	    </div><!-- ./wrapper -->


	    <!-- page script -->
	    <jsp:include page="/mulcms/includes/html_script.jsp" />
	    <!-- page script -->

  </body>
</html>
