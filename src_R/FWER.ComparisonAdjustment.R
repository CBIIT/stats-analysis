######################################
# File: FWER.ComparisonAdjustment.R
# Author: Huaitian Liu
# Date: September 2005
######################################

# Note: Input includes pvalues from t test or Wilcox test
#       Output - adjusted p-values

#       Multiple comparison adjustment:
#       Family-Wise Type-I Error Rate (FWER): Bonferroni

adjustP.Bonferroni <- function(pval) {
adjustP <- p.adjust(pval, "bonferroni", length(pval))
return(adjustP)
}
