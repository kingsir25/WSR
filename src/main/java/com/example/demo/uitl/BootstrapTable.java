package com.example.demo.uitl;

import org.springframework.data.domain.Page;

public class BootstrapTable
{
	private Integer page;
	private Long total;
	private Object rows;
	public Integer getPage()
	{
		return page;
	}
	public void setPage(Integer page)
	{
		this.page = page;
	}
	public Long getTotal()
	{
		return total;
	}
	public void setTotal(Long total)
	{
		this.total = total;
	}
	public Object getRows()
	{
		return rows;
	}
	public void setRows(Object rows)
	{
		this.rows = rows;
	}

	public static BootstrapTable turn(Page page)
	{
		BootstrapTable b = new BootstrapTable();
		b.setPage(page.getNumber() + 1);
		b.setTotal(page.getTotalElements());
		b.setRows(page.getContent());
		return b;
	}
}
