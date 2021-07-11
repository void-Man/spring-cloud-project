package com.cmj.example.mapper;

import com.cmj.example.base.EbuyPaymentBase;
import com.cmj.example.base.EbuyPaymentBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EbuyPaymentBaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    long countByExample(EbuyPaymentBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int insert(EbuyPaymentBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int insertSelective(@Param("record") EbuyPaymentBase record, @Param("selective") EbuyPaymentBase.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    EbuyPaymentBase selectOneByExample(EbuyPaymentBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    EbuyPaymentBase selectOneByExampleSelective(@Param("example") EbuyPaymentBaseExample example, @Param("selective") EbuyPaymentBase.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    List<EbuyPaymentBase> selectByExampleSelective(@Param("example") EbuyPaymentBaseExample example, @Param("selective") EbuyPaymentBase.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    List<EbuyPaymentBase> selectByExample(EbuyPaymentBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    EbuyPaymentBase selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EbuyPaymentBase.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    EbuyPaymentBase selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") EbuyPaymentBase record, @Param("example") EbuyPaymentBaseExample example, @Param("selective") EbuyPaymentBase.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") EbuyPaymentBase record, @Param("example") EbuyPaymentBaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(@Param("record") EbuyPaymentBase record, @Param("selective") EbuyPaymentBase.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(EbuyPaymentBase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int batchInsert(@Param("list") List<EbuyPaymentBase> list);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ebuy_payment
     *
     * @mbg.generated
     */
    int batchInsertSelective(@Param("list") List<EbuyPaymentBase> list, @Param("selective") EbuyPaymentBase.Column ... selective);
}