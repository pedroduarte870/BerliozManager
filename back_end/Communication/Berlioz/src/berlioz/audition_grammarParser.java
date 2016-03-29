package berlioz;

// Generated from /home/pedroduarte/Transferências/Berlioz/src/berlioz/audition_grammar.g4 by ANTLR 4.4

        import java.util.*;
        import java.io.*;
        import java.sql.*;
        import java.util.logging.Logger;
        import java.util.logging.Level;
        import java.lang.*;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class audition_grammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__22=1, T__21=2, T__20=3, T__19=4, T__18=5, T__17=6, T__16=7, T__15=8, 
		T__14=9, T__13=10, T__12=11, T__11=12, T__10=13, T__9=14, T__8=15, T__7=16, 
		T__6=17, T__5=18, T__4=19, T__3=20, T__2=21, T__1=22, T__0=23, STRING=24, 
		UNICODE_ESC=25, NUMBER=26, DATE_SEP=27, TIME_SEP=28, MINUTE_SEP=29, ID=30, 
		WS=31;
	public static final String[] tokenNames = {
		"<INVALID>", "'DURATION'", "'PLACE'", "'.'", "','", "'END GAMU'", "'METADATA'", 
		"'PERFORMANCE'", "'TITLE'", "'BEGIN AUDITION'", "'TIME'", "'PERFORMERS'", 
		"'PLAYS'", "';'", "'m'", "'SUBTITLE'", "'ORGANIZER'", "'PERFORMANCES'", 
		"'DATE'", "'BEGIN GAMU'", "'PLAY'", "'SUBJECT'", "'END AUDITION'", "'LEADERS'", 
		"STRING", "UNICODE_ESC", "NUMBER", "DATE_SEP", "TIME_SEP", "MINUTE_SEP", 
		"ID", "WS"
	};
	public static final int
		RULE_gamu = 0, RULE_audition = 1, RULE_metadata = 2, RULE_date = 3, RULE_time = 4, 
		RULE_duration = 5, RULE_performance = 6, RULE_leader = 7, RULE_performer = 8, 
		RULE_play = 9;
	public static final String[] ruleNames = {
		"gamu", "audition", "metadata", "date", "time", "duration", "performance", 
		"leader", "performer", "play"
	};

	@Override
	public String getGrammarFileName() { return "audition_grammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public audition_grammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GamuContext extends ParserRuleContext {
		public AuditionContext a1;
		public List<AuditionContext> audition() {
			return getRuleContexts(AuditionContext.class);
		}
		public AuditionContext audition(int i) {
			return getRuleContext(AuditionContext.class,i);
		}
		public GamuContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gamu; }
	}

	public final GamuContext gamu() throws RecognitionException {
		GamuContext _localctx = new GamuContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gamu);

		          ArrayList<ArrayList<String>> errors = new ArrayList<ArrayList<String>>();
		          int i=0;
		          int i2=0;
		          
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20); match(T__4);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(21); ((GamuContext)_localctx).a1 = audition();
				errors.add(((GamuContext)_localctx).a1.errorsOUT);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29); match(T__18);
			for(i=0;i<errors.size();i++){for(i2=0;i2<errors.get(i).size();i2++){ System.out.println(errors.get(i).get(i2)); }    } 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AuditionContext extends ParserRuleContext {
		public ArrayList<String> errorsOUT;
		public MetadataContext metadata;
		public PerformanceContext p1;
		public PerformanceContext p2;
		public List<PerformanceContext> performance() {
			return getRuleContexts(PerformanceContext.class);
		}
		public MetadataContext metadata() {
			return getRuleContext(MetadataContext.class,0);
		}
		public PerformanceContext performance(int i) {
			return getRuleContext(PerformanceContext.class,i);
		}
		public AuditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_audition; }
	}

	public final AuditionContext audition() throws RecognitionException {
		AuditionContext _localctx = new AuditionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_audition);
		int totalTime=0; int diff=0; BerliozInsert ber = new  BerliozInsert();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); match(T__14);
			setState(33); ((AuditionContext)_localctx).metadata = metadata(ber);
			setState(34); match(T__6);
			((AuditionContext)_localctx).errorsOUT = ((AuditionContext)_localctx).metadata.errorsOUT; ber = ((AuditionContext)_localctx).metadata.berOUT;
			setState(36); ((AuditionContext)_localctx).p1 = performance(_localctx.errorsOUT);
			((AuditionContext)_localctx).errorsOUT =  ((AuditionContext)_localctx).p1.errorsOUT;totalTime+=((AuditionContext)_localctx).p1.pTtime;ber.addPerformance(((AuditionContext)_localctx).p1.performanceOUT);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(38); ((AuditionContext)_localctx).p2 = performance(_localctx.errorsOUT);
				((AuditionContext)_localctx).errorsOUT =  ((AuditionContext)_localctx).p2.errorsOUT;totalTime+=((AuditionContext)_localctx).p2.pTtime;ber.addPerformance(((AuditionContext)_localctx).p2.performanceOUT);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46); match(T__1);
			 if(((AuditionContext)_localctx).metadata.durationA<totalTime){diff=totalTime-((AuditionContext)_localctx).metadata.durationA; _localctx.errorsOUT.add("Error : The expected duration isnt enough u need more: "+diff +" minutes");} 
			        if(_localctx.errorsOUT.size()==0){
			            ber.insertMeta();
			            ber.insertPerformances();
			            }
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MetadataContext extends ParserRuleContext {
		public BerliozInsert berIN;
		public int durationA;
		public ArrayList<String> errorsOUT;
		public BerliozInsert berOUT;
		public Token title;
		public Token subtitle;
		public Token subject;
		public Token organizer;
		public Token place;
		public DateContext date;
		public TimeContext time;
		public DurationContext duration;
		public TerminalNode STRING(int i) {
			return getToken(audition_grammarParser.STRING, i);
		}
		public DurationContext duration() {
			return getRuleContext(DurationContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public DateContext date() {
			return getRuleContext(DateContext.class,0);
		}
		public List<TerminalNode> STRING() { return getTokens(audition_grammarParser.STRING); }
		public MetadataContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public MetadataContext(ParserRuleContext parent, int invokingState, BerliozInsert berIN) {
			super(parent, invokingState);
			this.berIN = berIN;
		}
		@Override public int getRuleIndex() { return RULE_metadata; }
	}

	public final MetadataContext metadata(BerliozInsert berIN) throws RecognitionException {
		MetadataContext _localctx = new MetadataContext(_ctx, getState(), berIN);
		enterRule(_localctx, 4, RULE_metadata);
		((MetadataContext)_localctx).errorsOUT =  new ArrayList<String>() ;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49); match(T__17);
			setState(50); match(T__15);
			setState(51); ((MetadataContext)_localctx).title = match(STRING);
			setState(52); match(T__8);
			setState(53); ((MetadataContext)_localctx).subtitle = match(STRING);
			setState(54); match(T__2);
			setState(55); ((MetadataContext)_localctx).subject = match(STRING);
			setState(56); match(T__7);
			setState(57); ((MetadataContext)_localctx).organizer = match(STRING);
			setState(58); match(T__21);
			setState(59); ((MetadataContext)_localctx).place = match(STRING);
			setState(60); match(T__5);
			setState(61); ((MetadataContext)_localctx).date = date();
			setState(62); match(T__13);
			setState(63); ((MetadataContext)_localctx).time = time();
			setState(64); match(T__22);
			setState(65); ((MetadataContext)_localctx).duration = duration();
			setState(66); match(T__20);
			 ((MetadataContext)_localctx).durationA =  ((MetadataContext)_localctx).duration.durationMin ; if(((MetadataContext)_localctx).date.errorOUT.length() > 0){_localctx.errorsOUT.add(((MetadataContext)_localctx).date.errorOUT);}
			        ((MetadataContext)_localctx).berOUT =  _localctx.berIN; _localctx.berOUT.metadata((((MetadataContext)_localctx).title!=null?((MetadataContext)_localctx).title.getText():null),(((MetadataContext)_localctx).subtitle!=null?((MetadataContext)_localctx).subtitle.getText():null),(((MetadataContext)_localctx).subject!=null?((MetadataContext)_localctx).subject.getText():null),(((MetadataContext)_localctx).organizer!=null?((MetadataContext)_localctx).organizer.getText():null),(((MetadataContext)_localctx).place!=null?((MetadataContext)_localctx).place.getText():null),((MetadataContext)_localctx).date.formatDate,((MetadataContext)_localctx).time.formatTime,((MetadataContext)_localctx).duration.formatDuration);
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DateContext extends ParserRuleContext {
		public String errorOUT;
		public String formatDate;
		public Token day;
		public Token month;
		public Token year;
		public TerminalNode DATE_SEP(int i) {
			return getToken(audition_grammarParser.DATE_SEP, i);
		}
		public List<TerminalNode> DATE_SEP() { return getTokens(audition_grammarParser.DATE_SEP); }
		public TerminalNode NUMBER(int i) {
			return getToken(audition_grammarParser.NUMBER, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(audition_grammarParser.NUMBER); }
		public DateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date; }
	}

	public final DateContext date() throws RecognitionException {
		DateContext _localctx = new DateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_date);
		Calendar calendar = new GregorianCalendar();
		        ((DateContext)_localctx).errorOUT = "";
		      
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); ((DateContext)_localctx).day = match(NUMBER);
			setState(70); match(DATE_SEP);
			setState(71); ((DateContext)_localctx).month = match(NUMBER);
			setState(72); match(DATE_SEP);
			setState(73); ((DateContext)_localctx).year = match(NUMBER);
			 if(((((DateContext)_localctx).year!=null?Integer.valueOf(((DateContext)_localctx).year.getText()):0) >= calendar.get(Calendar.YEAR)) && ((((DateContext)_localctx).year!=null?Integer.valueOf(((DateContext)_localctx).year.getText()):0)<=calendar.get(Calendar.YEAR)+5)){ if((((DateContext)_localctx).year!=null?Integer.valueOf(((DateContext)_localctx).year.getText()):0)== calendar.get(Calendar.YEAR) && (((DateContext)_localctx).month!=null?Integer.valueOf(((DateContext)_localctx).month.getText()):0) < calendar.get(Calendar.MONTH)+1 ){((DateContext)_localctx).errorOUT = "Error in the date of the event: The month is wrong"; }
			        else{if((((DateContext)_localctx).year!=null?Integer.valueOf(((DateContext)_localctx).year.getText()):0)== calendar.get(Calendar.YEAR) && (((DateContext)_localctx).month!=null?Integer.valueOf(((DateContext)_localctx).month.getText()):0) == (calendar.get(Calendar.MONTH)+1) && (((DateContext)_localctx).day!=null?Integer.valueOf(((DateContext)_localctx).day.getText()):0) <= calendar.get(Calendar.DAY_OF_MONTH) ){((DateContext)_localctx).errorOUT = "Error in the date of the event: The day is wrong (events can only be schedule for dates after today!)";}}
			        }else{((DateContext)_localctx).errorOUT = "Error in the date of the event: The year is wrong (range=5)";}
			        ((DateContext)_localctx).formatDate =  (((DateContext)_localctx).day!=null?((DateContext)_localctx).day.getText():null)+"/"+(((DateContext)_localctx).month!=null?((DateContext)_localctx).month.getText():null)+"/"+(((DateContext)_localctx).year!=null?((DateContext)_localctx).year.getText():null); 
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TimeContext extends ParserRuleContext {
		public String formatTime;
		public Token hour;
		public Token min;
		public TerminalNode NUMBER(int i) {
			return getToken(audition_grammarParser.NUMBER, i);
		}
		public TerminalNode TIME_SEP() { return getToken(audition_grammarParser.TIME_SEP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(audition_grammarParser.NUMBER); }
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); ((TimeContext)_localctx).hour = match(NUMBER);
			setState(77); match(TIME_SEP);
			setState(78); ((TimeContext)_localctx).min = match(NUMBER);
			setState(80);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(79); match(T__9);
				}
			}

			((TimeContext)_localctx).formatTime =  (((TimeContext)_localctx).hour!=null?((TimeContext)_localctx).hour.getText():null) + "h" + (((TimeContext)_localctx).min!=null?((TimeContext)_localctx).min.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DurationContext extends ParserRuleContext {
		public int durationMin;
		public String formatDuration;
		public Token hour;
		public Token min;
		public TerminalNode NUMBER(int i) {
			return getToken(audition_grammarParser.NUMBER, i);
		}
		public TerminalNode TIME_SEP() { return getToken(audition_grammarParser.TIME_SEP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(audition_grammarParser.NUMBER); }
		public DurationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_duration; }
	}

	public final DurationContext duration() throws RecognitionException {
		DurationContext _localctx = new DurationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_duration);
		((DurationContext)_localctx).formatDuration = "";
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(84); ((DurationContext)_localctx).hour = match(NUMBER);
				setState(85); match(TIME_SEP);
				}
				break;
			}
			setState(88); ((DurationContext)_localctx).min = match(NUMBER);
			setState(90);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(89); match(T__9);
				}
			}

			if(((DurationContext)_localctx).hour!=null){((DurationContext)_localctx).durationMin = (((DurationContext)_localctx).hour!=null?Integer.valueOf(((DurationContext)_localctx).hour.getText()):0)*60+(((DurationContext)_localctx).min!=null?Integer.valueOf(((DurationContext)_localctx).min.getText()):0); _localctx.formatDuration+=(((DurationContext)_localctx).hour!=null?((DurationContext)_localctx).hour.getText():null)+"h"; }else{((DurationContext)_localctx).durationMin = (((DurationContext)_localctx).min!=null?Integer.valueOf(((DurationContext)_localctx).min.getText()):0);}
			            _localctx.formatDuration+=(((DurationContext)_localctx).min!=null?((DurationContext)_localctx).min.getText():null)+"m";
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PerformanceContext extends ParserRuleContext {
		public ArrayList<String> errorsIN;
		public ArrayList<String> errorsOUT;
		public int pTtime;
		public Performance performanceOUT;
		public Token designation;
		public LeaderContext l1;
		public LeaderContext l2;
		public PerformerContext p1;
		public PerformerContext p2;
		public PlayContext pl1;
		public PlayContext pl2;
		public List<PerformerContext> performer() {
			return getRuleContexts(PerformerContext.class);
		}
		public LeaderContext leader(int i) {
			return getRuleContext(LeaderContext.class,i);
		}
		public PlayContext play(int i) {
			return getRuleContext(PlayContext.class,i);
		}
		public List<PlayContext> play() {
			return getRuleContexts(PlayContext.class);
		}
		public List<LeaderContext> leader() {
			return getRuleContexts(LeaderContext.class);
		}
		public TerminalNode STRING() { return getToken(audition_grammarParser.STRING, 0); }
		public PerformerContext performer(int i) {
			return getRuleContext(PerformerContext.class,i);
		}
		public PerformanceContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PerformanceContext(ParserRuleContext parent, int invokingState, ArrayList<String> errorsIN) {
			super(parent, invokingState);
			this.errorsIN = errorsIN;
		}
		@Override public int getRuleIndex() { return RULE_performance; }
	}

	public final PerformanceContext performance(ArrayList<String> errorsIN) throws RecognitionException {
		PerformanceContext _localctx = new PerformanceContext(_ctx, getState(), errorsIN);
		enterRule(_localctx, 12, RULE_performance);
		HashSet<String> p = new HashSet<String>();
		          HashSet<String> l = new HashSet<String>();
		          HashSet<String> pl = new HashSet<String>();
		          ((PerformanceContext)_localctx).performanceOUT =  new Performance();
		          ((PerformanceContext)_localctx).pTtime = 0;
		          ((PerformanceContext)_localctx).errorsOUT = _localctx.errorsIN;
		          String group="";
		        
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); match(T__16);
			setState(96);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(95); ((PerformanceContext)_localctx).designation = match(STRING);
				}
			}

			if(((PerformanceContext)_localctx).designation==null){group="";}else{group=(((PerformanceContext)_localctx).designation!=null?((PerformanceContext)_localctx).designation.getText():null);_localctx.performanceOUT.addDesignation((((PerformanceContext)_localctx).designation!=null?((PerformanceContext)_localctx).designation.getText():null));} 
			setState(99); match(T__0);
			setState(100); ((PerformanceContext)_localctx).l1 = leader(l,_localctx.errorsIN,_localctx.performanceOUT);
			l = ((PerformanceContext)_localctx).l1.lOUT; ((PerformanceContext)_localctx).errorsOUT =  ((PerformanceContext)_localctx).l1.errorsOUT; ((PerformanceContext)_localctx).performanceOUT =  ((PerformanceContext)_localctx).l1.performanceOUT;
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(102); match(T__19);
				setState(103); ((PerformanceContext)_localctx).l2 = leader(l,_localctx.errorsOUT,_localctx.performanceOUT );
				l = ((PerformanceContext)_localctx).l2.lOUT;((PerformanceContext)_localctx).errorsOUT =  ((PerformanceContext)_localctx).l2.errorsOUT;((PerformanceContext)_localctx).performanceOUT =  ((PerformanceContext)_localctx).l2.performanceOUT;
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111); match(T__12);
			setState(112); ((PerformanceContext)_localctx).p1 = performer(p,_localctx.errorsOUT,group,_localctx.performanceOUT);
			p = ((PerformanceContext)_localctx).p1.pOUT; ((PerformanceContext)_localctx).errorsOUT =  ((PerformanceContext)_localctx).p1.errorsOUT;((PerformanceContext)_localctx).performanceOUT =  ((PerformanceContext)_localctx).p1.performanceOUT;
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(114); match(T__19);
				setState(115); ((PerformanceContext)_localctx).p2 = performer(p,_localctx.errorsOUT,group,_localctx.performanceOUT);
				p = ((PerformanceContext)_localctx).p2.pOUT;((PerformanceContext)_localctx).errorsOUT =  ((PerformanceContext)_localctx).p2.errorsOUT;((PerformanceContext)_localctx).performanceOUT =  ((PerformanceContext)_localctx).p2.performanceOUT;
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123); match(T__11);
			setState(124); ((PerformanceContext)_localctx).pl1 = play(pl,_localctx.errorsIN,_localctx.performanceOUT);
			pl = ((PerformanceContext)_localctx).pl1.plOUT; ((PerformanceContext)_localctx).errorsOUT =  ((PerformanceContext)_localctx).pl1.errorsOUT;_localctx.pTtime+=((PerformanceContext)_localctx).pl1.timeP;((PerformanceContext)_localctx).performanceOUT =  ((PerformanceContext)_localctx).pl1.performanceOUT;
			setState(126); match(T__10);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(127); ((PerformanceContext)_localctx).pl2 = play(pl,_localctx.errorsOUT,_localctx.performanceOUT );
				pl = ((PerformanceContext)_localctx).pl2.plOUT;((PerformanceContext)_localctx).errorsOUT =  ((PerformanceContext)_localctx).pl2.errorsOUT;_localctx.pTtime+=((PerformanceContext)_localctx).pl2.timeP;((PerformanceContext)_localctx).performanceOUT =  ((PerformanceContext)_localctx).pl2.performanceOUT;
				setState(129); match(T__10);
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(136); match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LeaderContext extends ParserRuleContext {
		public HashSet<String> lIN;
		public ArrayList<String> errorsIN;
		public Performance performanceIN;
		public HashSet<String> lOUT;
		public ArrayList<String> errorsOUT;
		public Performance performanceOUT;
		public Token l;
		public TerminalNode ID() { return getToken(audition_grammarParser.ID, 0); }
		public LeaderContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public LeaderContext(ParserRuleContext parent, int invokingState, HashSet<String> lIN, ArrayList<String> errorsIN, Performance performanceIN) {
			super(parent, invokingState);
			this.lIN = lIN;
			this.errorsIN = errorsIN;
			this.performanceIN = performanceIN;
		}
		@Override public int getRuleIndex() { return RULE_leader; }
	}

	public final LeaderContext leader(HashSet<String> lIN,ArrayList<String> errorsIN,Performance performanceIN) throws RecognitionException {
		LeaderContext _localctx = new LeaderContext(_ctx, getState(), lIN, errorsIN, performanceIN);
		enterRule(_localctx, 14, RULE_leader);
		((LeaderContext)_localctx).lOUT = _localctx.lIN; ((LeaderContext)_localctx).errorsOUT =  _localctx.errorsIN; BerliozData conn = new BerliozData(); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); ((LeaderContext)_localctx).l = match(ID);
			if(!_localctx.lOUT.add((((LeaderContext)_localctx).l!=null?((LeaderContext)_localctx).l.getText():null))){_localctx.errorsOUT.add("Error adding leader: U already added "+(((LeaderContext)_localctx).l!=null?((LeaderContext)_localctx).l.getText():null) +" to the performance...");}
			          if(!conn.exitsTeacherID((((LeaderContext)_localctx).l!=null?((LeaderContext)_localctx).l.getText():null))){_localctx.errorsOUT.add("Error adding leader: the teacher "+(((LeaderContext)_localctx).l!=null?((LeaderContext)_localctx).l.getText():null) +" doesnt exist");}
			        conn.closeConn();
			            ((LeaderContext)_localctx).performanceOUT =  _localctx.performanceIN; _localctx.performanceOUT.addLeader((((LeaderContext)_localctx).l!=null?((LeaderContext)_localctx).l.getText():null));
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PerformerContext extends ParserRuleContext {
		public HashSet<String> pIN;
		public ArrayList<String> errorsIN;
		public String group;
		public Performance performanceIN;
		public HashSet<String> pOUT;
		public ArrayList<String> errorsOUT;
		public Performance performanceOUT;
		public Token p;
		public TerminalNode ID() { return getToken(audition_grammarParser.ID, 0); }
		public PerformerContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PerformerContext(ParserRuleContext parent, int invokingState, HashSet<String> pIN, ArrayList<String> errorsIN, String group, Performance performanceIN) {
			super(parent, invokingState);
			this.pIN = pIN;
			this.errorsIN = errorsIN;
			this.group = group;
			this.performanceIN = performanceIN;
		}
		@Override public int getRuleIndex() { return RULE_performer; }
	}

	public final PerformerContext performer(HashSet<String> pIN,ArrayList<String> errorsIN,String group,Performance performanceIN) throws RecognitionException {
		PerformerContext _localctx = new PerformerContext(_ctx, getState(), pIN, errorsIN, group, performanceIN);
		enterRule(_localctx, 16, RULE_performer);
		((PerformerContext)_localctx).pOUT = _localctx.pIN; ((PerformerContext)_localctx).errorsOUT =  _localctx.errorsIN; BerliozData conn = new BerliozData();
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); ((PerformerContext)_localctx).p = match(ID);
			if(!_localctx.pOUT.add((((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null))){_localctx.errorsOUT.add("Error adding performer: U already added"+(((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null) +" to the performance...");}
			           if(!conn.exitsStudentID((((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null)) && !conn.exitsTeacherID((((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null)) ){_localctx.errorsOUT.add("Error adding performer: the performer"+(((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null) +" doesnt exist...");}
			           
			           ((PerformerContext)_localctx).performanceOUT =  _localctx.performanceIN; if(!_localctx.performanceOUT.isGroup()){if(!_localctx.performanceOUT.studentAdded()){_localctx.performanceOUT.addStudent((((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null));}
			            else{_localctx.errorsOUT.add("Error adding performer: performence lacks designation, so only one student can be added, so "+(((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null)+ "can't be added "); }}
			           else{ if(!conn.isInGroup((((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null),_localctx.group)){_localctx.errorsOUT.add("Error adding performer: performer "+(((PerformerContext)_localctx).p!=null?((PerformerContext)_localctx).p.getText():null)+ " isn´t included in group "+_localctx.group );}  }
			            conn.closeConn();
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlayContext extends ParserRuleContext {
		public HashSet<String> plIN;
		public ArrayList<String> errorsIN;
		public Performance performanceIN;
		public HashSet<String> plOUT;
		public ArrayList<String> errorsOUT;
		public int timeP;
		public Performance performanceOUT;
		public Token p;
		public TerminalNode ID() { return getToken(audition_grammarParser.ID, 0); }
		public PlayContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PlayContext(ParserRuleContext parent, int invokingState, HashSet<String> plIN, ArrayList<String> errorsIN, Performance performanceIN) {
			super(parent, invokingState);
			this.plIN = plIN;
			this.errorsIN = errorsIN;
			this.performanceIN = performanceIN;
		}
		@Override public int getRuleIndex() { return RULE_play; }
	}

	public final PlayContext play(HashSet<String> plIN,ArrayList<String> errorsIN,Performance performanceIN) throws RecognitionException {
		PlayContext _localctx = new PlayContext(_ctx, getState(), plIN, errorsIN, performanceIN);
		enterRule(_localctx, 18, RULE_play);
		((PlayContext)_localctx).plOUT = _localctx.plIN; ((PlayContext)_localctx).errorsOUT =  _localctx.errorsIN; BerliozData conn = new BerliozData(); 
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); match(T__3);
			setState(145); ((PlayContext)_localctx).p = match(ID);
			if(!_localctx.plOUT.add((((PlayContext)_localctx).p!=null?((PlayContext)_localctx).p.getText():null))){_localctx.errorsOUT.add("Error adding piece: U already added "+(((PlayContext)_localctx).p!=null?((PlayContext)_localctx).p.getText():null) +" to the performance...");}
			       if(!conn.exitsPieceID((((PlayContext)_localctx).p!=null?((PlayContext)_localctx).p.getText():null))){_localctx.errorsOUT.add("Error adding piece: The piece "+(((PlayContext)_localctx).p!=null?((PlayContext)_localctx).p.getText():null) +" doesnt exist...");}
			       else{((PlayContext)_localctx).timeP =  conn.pieceDuration((((PlayContext)_localctx).p!=null?((PlayContext)_localctx).p.getText():null));}
			        ((PlayContext)_localctx).performanceOUT =  _localctx.performanceIN; _localctx.performanceOUT.addPiece((((PlayContext)_localctx).p!=null?((PlayContext)_localctx).p.getText():null));
			        conn.closeConn();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3!\u0097\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\5\6S\n\6\3\6\3\6\3\7\3"+
		"\7\5\7Y\n\7\3\7\3\7\5\7]\n\7\3\7\3\7\3\b\3\b\5\bc\n\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7"+
		"\by\n\b\f\b\16\b|\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0086\n\b\f"+
		"\b\16\b\u0089\13\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\u0095\2\26\3\2\2\2\4\"\3\2\2\2"+
		"\6\63\3\2\2\2\bG\3\2\2\2\nN\3\2\2\2\fX\3\2\2\2\16`\3\2\2\2\20\u008c\3"+
		"\2\2\2\22\u008f\3\2\2\2\24\u0092\3\2\2\2\26\34\7\25\2\2\27\30\5\4\3\2"+
		"\30\31\b\2\1\2\31\33\3\2\2\2\32\27\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2"+
		"\34\35\3\2\2\2\35\37\3\2\2\2\36\34\3\2\2\2\37 \7\7\2\2 !\b\2\1\2!\3\3"+
		"\2\2\2\"#\7\13\2\2#$\5\6\4\2$%\7\23\2\2%&\b\3\1\2&\'\5\16\b\2\'-\b\3\1"+
		"\2()\5\16\b\2)*\b\3\1\2*,\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2"+
		"\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\30\2\2\61\62\b\3\1\2\62\5\3\2\2\2\63"+
		"\64\7\b\2\2\64\65\7\n\2\2\65\66\7\32\2\2\66\67\7\21\2\2\678\7\32\2\28"+
		"9\7\27\2\29:\7\32\2\2:;\7\22\2\2;<\7\32\2\2<=\7\4\2\2=>\7\32\2\2>?\7\24"+
		"\2\2?@\5\b\5\2@A\7\f\2\2AB\5\n\6\2BC\7\3\2\2CD\5\f\7\2DE\7\5\2\2EF\b\4"+
		"\1\2F\7\3\2\2\2GH\7\34\2\2HI\7\35\2\2IJ\7\34\2\2JK\7\35\2\2KL\7\34\2\2"+
		"LM\b\5\1\2M\t\3\2\2\2NO\7\34\2\2OP\7\36\2\2PR\7\34\2\2QS\7\20\2\2RQ\3"+
		"\2\2\2RS\3\2\2\2ST\3\2\2\2TU\b\6\1\2U\13\3\2\2\2VW\7\34\2\2WY\7\36\2\2"+
		"XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\7\34\2\2[]\7\20\2\2\\[\3\2\2\2\\]\3"+
		"\2\2\2]^\3\2\2\2^_\b\7\1\2_\r\3\2\2\2`b\7\t\2\2ac\7\32\2\2ba\3\2\2\2b"+
		"c\3\2\2\2cd\3\2\2\2de\b\b\1\2ef\7\31\2\2fg\5\20\t\2gn\b\b\1\2hi\7\6\2"+
		"\2ij\5\20\t\2jk\b\b\1\2km\3\2\2\2lh\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2"+
		"\2\2oq\3\2\2\2pn\3\2\2\2qr\7\r\2\2rs\5\22\n\2sz\b\b\1\2tu\7\6\2\2uv\5"+
		"\22\n\2vw\b\b\1\2wy\3\2\2\2xt\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}"+
		"\3\2\2\2|z\3\2\2\2}~\7\16\2\2~\177\5\24\13\2\177\u0080\b\b\1\2\u0080\u0087"+
		"\7\17\2\2\u0081\u0082\5\24\13\2\u0082\u0083\b\b\1\2\u0083\u0084\7\17\2"+
		"\2\u0084\u0086\3\2\2\2\u0085\u0081\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2\2\2\u008a"+
		"\u008b\7\5\2\2\u008b\17\3\2\2\2\u008c\u008d\7 \2\2\u008d\u008e\b\t\1\2"+
		"\u008e\21\3\2\2\2\u008f\u0090\7 \2\2\u0090\u0091\b\n\1\2\u0091\23\3\2"+
		"\2\2\u0092\u0093\7\26\2\2\u0093\u0094\7 \2\2\u0094\u0095\b\13\1\2\u0095"+
		"\25\3\2\2\2\13\34-RX\\bnz\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}