package ch.todesstern.emspielplanapp;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Collections;

import ch.todesstern.emspielplanapp.util.MannschaftsComparator;

import static org.junit.Assert.*;

/**
 * Created by kutt on 28.06.2016.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MannschaftsComparatorTest
{
    Mannschaft m1;
    Mannschaft m2;
    MannschaftsComparator comparator;

    @Before
    public void setUp() throws Exception
    {
        m1 = new Mannschaft();
        m1.setName("m1");
        m2 = new Mannschaft();
        m2.setName("m2");
        comparator = new MannschaftsComparator(MannschaftsComparator.ASC);
    }

    @Test
    public void test_a_compare()
    {
        int compVal = comparator.compare(m1, m2);
        Assert.assertEquals(0, compVal);
    }

    @Test
    public void test_b_compareTorDiff()
    {
        m1.addTorDiff(1);
        int compVal = comparator.compare(m1, m2);
        Assert.assertEquals(1, compVal);
    }

    @Test
    public void test_c_compareTorSum()
    {
        m2.addTore(1);
        int compVal = comparator.compare(m1, m2);
        Assert.assertEquals(-1, compVal);
    }

    @Test
    public void test_d_compareWin()
    {
        m1.gewonnen.add(m2.getName());
        int compVal = comparator.compare(m1, m2);
        Assert.assertEquals(1, compVal);
    }

    @Test
    public void test_e_comparePkt()
    {
        m2.addPunkte(1);
        int compVal = comparator.compare(m1, m2);
        Assert.assertEquals(-1, compVal);
    }
}
