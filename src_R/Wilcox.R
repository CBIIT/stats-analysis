##############################################################################################################
# File: Wilcox.R
# Author: Huaitian Liu
# Date: September 2005
###############################################################################################################

#  Note: Input includes data matrix containing log2 expression data (Genes in rows, Expts in cols)
#        First column in data matrix contains row identifiers (Reporters).

#        The results are (a header line and):
#        Wilcoxon: median of group1, median of group2, difference of medians, absolute fold change, p-values

### Wilcoxon rank sum test is the nonparametric analog to the independent two-sample t-test. 

 mywilcox <- function(datmat,index1,index2,
    datafilter=as.numeric){
  # datmat matrix of normalized expression values (reporters * arrays)
 
  f <- function(i) {
      return(wilcox.test(datafilter(datmat[i,index1]),
      datafilter(datmat[i,index2]))$p.value)
      }
    median1 <- apply(datmat[,index1],1, median)
    median2 <- apply(datmat[,index2],1, median)
    result<-return(data.frame(median1, median2, median.dif=median1-median2,fc=2^(abs(median1-median2)),pval=sapply(1:length(datmat[,1]),f)))
   }
  
 
