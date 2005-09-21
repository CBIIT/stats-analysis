###################################
# File: FDR.ComparisonAdjustment.R
# Author: Huaitian Liu
# Date: September 2005
###################################

# Note: Input includes pvalues from t test or Wilcox test
#       Output - adjusted p-values

#       Multiple comparison adjustment:
#       False Discovery Rate (FDR): Benjamini-Hochberg

adjustP.Benjamini.Hochberg <- function(pval) {
adjustP <- p.adjust(pval, "BH", length(pval))
return(adjustP)
}
