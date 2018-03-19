package cn.lyc.bean;


public class PdfOut {
	
	private String id;
	private String kprq;
	private String fphm;
	private String fileName;
	private byte[] pdfFileData;
	private String fpdm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFpdm() {
		return fpdm;
	}
	public void setFpdm(String fpdm) {
		this.fpdm = fpdm;
	}
	public String getKprq() {
		return kprq;
	}
	public void setKprq(String kprq) {
		this.kprq = kprq;
	}
	public String getFphm() {
		return fphm;
	}
	public void setFphm(String fphm) {
		this.fphm = fphm;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getPdfFileData() {
		return pdfFileData;
	}
	public void setPdfFileData(byte[] pdfFileData) {
		this.pdfFileData = pdfFileData;
	}
}
